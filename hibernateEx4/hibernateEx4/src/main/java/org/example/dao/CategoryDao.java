package org.example.dao;

import jakarta.persistence.criteria.CriteriaQuery;
import org.example.dto.CategoryDTO;
import org.example.entity.Category;
import org.example.enums.MatchMode;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.print.Doc;
import javax.print.DocFlavor;
import java.util.List;

public class CategoryDao {


    private static Session session(){
      Session session= HibernateUtil.sessionFactory.openSession();
      return session;
    }


    public List<Category> findAll(){
        Query<Category> select_category_from_category_category =
                session().createQuery("select category from Category category", Category.class);
        return select_category_from_category_category.getResultList();
    }
    public Category getCategoryById(Long id){


        Query query = session().createQuery("select category from Category category where id=:id", Category.class);
        query.setParameter("id",id);

        return (Category) query.uniqueResult();

    }
    public List<Category> findCategoryNameLikeParam(MatchMode matchMode ,String param){
        Query<Category> query = session().createQuery("select category from Category category  where  categoryName like :matchMode", Category.class);

        switch (matchMode){
            case END -> query.setParameter("matchMode","%"+param);
            case START -> query.setParameter("matchMode",param+"%");
            case ANYWHERE -> query.setParameter("matchMode","%"+param+"%");
            case NORMAL -> query.setParameter("matchMode",param);


        }
        return query.list();
    }

    public List<Category> getCategoryBetweenMaxAndMin(Long max,Long min){
        Query query = session().createQuery("select category from  Category  category where   id  between  :max and :min  ", Category.class);
        query.setParameter("max",max);
        query.setParameter("min",min);
        return query.list();
    }

    public List<Category> getCategoryOrderById(){
        Query<Category> query = session().createQuery("select category from  Category category order by id DESC ,categoryName asc ", Category.class);
        return query.list();
    }

    public Long getSumId(){
        Query<Long> query = session().createQuery("select sum(category.id) from Category category  ", Long.class);
        return query.uniqueResult();
    }
    public Long getCount(){
        Query<Long> query = session().createQuery("select count(category)  from " +
                "Category  category ", Long.class);
        return query.uniqueResult();
    }
    public List<String> useDistic(){
        Query<String> query = session().createQuery("select distinct (c.categoryType) from Category  c ", String.class);
        return query.list();
    }

    public  Double useAvg(){
        Query<Double> query = session().createQuery("select  avg(c.id) from Category  c ", Double.class);
        return query.uniqueResult();

    }
    public CategoryDTO useProjection(Long id){
        Query<CategoryDTO> query = session().createQuery("select new org.example.dto.CategoryDTO(c.id,c.categoryName)from Category  c where c.id=:id", CategoryDTO.class);
        query.setParameter("id",id);
        return query.uniqueResult();

    }

    public static void main(String[] args) {
        CategoryDao categoryDao=new CategoryDao();
        System.out.println(categoryDao.useProjection(1l).toString());


    }


}
