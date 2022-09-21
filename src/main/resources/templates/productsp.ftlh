<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BuySell</title>
</head>
<body>
    <h1>BUYSELL<h1><hr>
    <h4>Все товары</h4>
    <form action="/" method="get">
    	Search by attention name: <input type="text" name="title"><br>
    	<input type="submit" value="Search"/>
    </form>
    <#list products as prod>
    	<div>
    		<p><b>${prod.title}</b> <b>${prod.price} uah</b> | <a href="/product/${prod.ID}">More...</a></p>
    	</div> 
    	<#else>
    	<h3>Товаров нет</h3>
    </#list>
    <hr>
    <h3>Созадать новый товар</h3>
    <form action="/product/create" method="post" enctype="multipart/form-data">
    	Название объявления: <input type="text" name="title"/><br><br>
    	Описание объявления: <input type="text" name="description"/><br><br>
    	Цена: <input type="number" name="price"/><br><br>
    	Город: <input type="text" name="city"/><br><br>
    	Имя: <input type="text" name="author"/><br><br>
        Первая фотография: <input type="file" name="file1"/><br><br>
        Вторая фотография: <input type="file" name="file2"/><br><br>
        Третья фотография: <input type="file" name="file3"/><br><br>
    	<input type="submit" value="Добавить товар">
</body>
</html>