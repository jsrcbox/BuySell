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
    <h4>Подробная информация о товаре</h4>
    <#list images as img>
    	<img src="/images/${img.id}" height="60px"><br><br>
    </#list>
	<b>Название товара: </b>${product.title}<br>
	<b>Описание товара: </b>${product.description}<br>
	<b>Цена: </b>${product.price}<br>
	<b>Город: </b>${product.city}<br>
	<b>Автор: </b>${product.author}<br>
    <hr>
    <form action="/product/delete/${product.ID}" method="post">
    	<input type="submit" value="Удалить товар">
</body>
</html>