package org.nix.movieticketingsystem.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.movieticketingsystem.MovieTicketingSystemApplication;
import org.nix.movieticketingsystem.pojo.dao.CinemaRepository;
import org.nix.movieticketingsystem.pojo.dao.MovieRepository;
import org.nix.movieticketingsystem.pojo.dao.entitymanger.session.CinemaDao;
import org.nix.movieticketingsystem.pojo.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieTicketingSystemApplication.class)
public class DatabasesTest {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Test
    public void listAddMovie(){

        Movie tangrenjie = new Movie();
        tangrenjie.setDirector("王宝强");
        tangrenjie.setHot(9);
        tangrenjie.setMovieName("唐人街探案");
        tangrenjie.setPictureUrl("/picture/tangrenjie.jpg");
        tangrenjie.setScore(8.9);
        tangrenjie.setStarring("王宝强");

        Movie gangtiexia = new Movie();
        gangtiexia.setDirector("王宝强");
        gangtiexia.setHot(9);
        gangtiexia.setMovieName("钢铁侠");
        gangtiexia.setPictureUrl("/picture/tangrenjie.jpg");
        gangtiexia.setScore(8.9);
        gangtiexia.setStarring("王宝强");


        Movie sanguo = new Movie();
        sanguo.setDirector("王宝强");
        sanguo.setHot(9);
        sanguo.setMovieName("三国演义");
        sanguo.setPictureUrl("/picture/tangrenjie.jpg");
        sanguo.setScore(8.9);
        sanguo.setStarring("王宝强");


        Movie qingqingcaoyuan = new Movie();
        qingqingcaoyuan.setDirector("王宝强");
        qingqingcaoyuan.setHot(9);
        qingqingcaoyuan.setMovieName("青青草原");
        qingqingcaoyuan.setPictureUrl("/picture/tangrenjie.jpg");
        qingqingcaoyuan.setScore(8.9);
        qingqingcaoyuan.setStarring("王宝强");

        Movie qingchun = new Movie();
        qingchun.setDirector("王宝强");
        qingchun.setHot(9);
        qingchun.setMovieName("青春");
        qingchun.setPictureUrl("/picture/tangrenjie.jpg");
        qingchun.setScore(8.9);
        qingchun.setStarring("王宝强");

        List<Movie> movies = new ArrayList<>();
        movies.add(tangrenjie);
        movies.add(gangtiexia);
        movies.add(sanguo);
        movies.add(qingqingcaoyuan);
        movies.add(qingchun);
        movieRepository.saveAll(movies);


//        Movie love = new Movie();
//        love.setDirector();
//        love.setHot();
//        love.setMovieName();
//        love.setPictureUrl();
//        love.setScore();
//        love.setStarring();
//
//        Movie yuanlaishini = new Movie();
//        yuanlaishini.setDirector();
//        yuanlaishini.setHot();
//        yuanlaishini.setMovieName();
//        yuanlaishini.setPictureUrl();
//        yuanlaishini.setScore();
//        yuanlaishini.setStarring();
//
//        Movie womenjiehunba = new Movie();
//        womenjiehunba.setDirector();
//        womenjiehunba.setHot();
//        womenjiehunba.setMovieName();
//        womenjiehunba.setPictureUrl();
//        womenjiehunba.setScore();
//        womenjiehunba.setStarring();
//
//        Movie daomengkongjian = new Movie();
//        daomengkongjian.setDirector();
//        daomengkongjian.setHot();
//        daomengkongjian.setMovieName();
//        daomengkongjian.setPictureUrl();
//        daomengkongjian.setScore();
//        daomengkongjian.setStarring();
    }

    @Test
    public void finHotMovieListTest(){
        List<Movie> movies = movieRepository.finHotMovieList(2);
        System.out.println();
    }



    @Test
    public void findAllByMovieNameTest(){
        System.out.println();
    }

    @Test
    public void CountByMovieNameTest(){
        cinemaRepository.CountByMovieName("a");
        System.out.println();
    }


    @Autowired
    private CinemaDao cinemaDao;

    @Test
    public void selectTest(){
        cinemaDao.findAllByMovieName("a",1,10);
        System.out.println();
    }
}
