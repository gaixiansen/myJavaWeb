<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/11
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>jsp test</title>
    <script type="text/javascript" >
      /**
       * 使得selecte的默认值根据入参确定
       * @param t
       */
      function setProductCategory(t) {
        // document.write("come in setProductCategory")
        var category = document.getElementById("category");
        var options = category.options;
        for (var i = 0; i < options.length; i++) {
          var option = options[i];
          if (t == option.value){
            option.selected = true;
            return;
          }
        }
      }
    </script>
  </head>
  <body onload="setProductCategory('科技')">
    <select name="category" id="category" >
      <option value="">选择商品类别 </option>
      <option value="科技"> 科技</option>
      <option value="文学"> 文学</option>
      <option value="生活"> 生活</option>
      <option value="历史"> 历史</option>
    </select>
  </body>
</html>
