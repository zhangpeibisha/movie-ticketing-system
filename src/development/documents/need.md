由于麦克风问题，所以请求打字解释，如果有什么疑问，欢迎访问GITHUB查询提交日记
或者我申请答辩。

github:https://github.com/zhangpeibisha/movie-ticketing-system

1.首先观看目录结构：
  1.1服务器代码接口
     我将代码分为普通java代码、服务代码、和接口层代码
     1.1.2服务层代码：
        dao:操作数据库代码
        dto:用来和前端交互信息的整合和处理
        entity:整个系统中涉及到的实体对象
        server：用户处理用户的业务逻辑
     1.1.3接口层代码：
        标签：用来实现权限校验、注入当前用户对象等
        controller：用来与前端ajax进行数据交互的接口集合
        handler:用来处理接口层的一些业务
   1.2前端页面
     由于时间有限，有些界面写好了没有完全和接口对接上。
     目前完成完全对接的页面有：
     index.html
     addMovie.html
     createOrder.html
     login.html
     movieDeatil.html
     myHome.html
     recharge.html
     register.html
     repassword.html
     尚未完善页面：
     showCineMovie.html
     showTobeReleasess.html
     
* 上传图片位于：
target/movie_ticketing_system/WEB-INF/classes/static/images

现在开始演示
     
     
     