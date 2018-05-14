package org.nix.movieticketingsystem.pojo.server;

import org.nix.movieticketingsystem.commons.utils.file.FileUtil;
import org.nix.movieticketingsystem.pojo.dao.MovieRepository;
import org.nix.movieticketingsystem.pojo.dto.FindTopMovieDto;
import org.nix.movieticketingsystem.pojo.dto.base.BaseResultDto;
import org.nix.movieticketingsystem.pojo.entity.Cinema;
import org.nix.movieticketingsystem.pojo.entity.Movie;
import org.nix.movieticketingsystem.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 */
@Service
public class MovieServer {

    @Autowired
    private MovieRepository movieRepository;

    public BaseResultDto findTopTenMovie(int countMovie) {
        List<Movie> movies = movieRepository.finHotMovieList(countMovie);
        return new FindTopMovieDto(movies).result();
    }

    /**
     * 添加电影信息
     *
     * @param movie   电影基本信息
     * @param picture 电影海报
     * @return 操作结果
     */
    public boolean addMovie(Movie movie, MultipartFile picture, HttpServletRequest request) {

        try {
            String path = FileUtil.write(picture, request);
            movie.setPictureUrl(path);
            movieRepository.save(movie);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
