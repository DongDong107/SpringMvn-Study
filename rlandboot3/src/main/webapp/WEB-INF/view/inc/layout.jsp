<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../css/reset.css" type="text/css" rel="stylesheet" >
    <link href="../css/style.css" type="text/css" rel="stylesheet" >
    <link href="../css/layout.css" type="text/css" rel="stylesheet" >
    <link href="../css/header.css" type="text/css" rel="stylesheet" >
    <link href="../css/footer.css" type="text/css" rel="stylesheet" >
	<link href="../css/component/aside.css" type="text/css" rel="stylesheet" >
	<link href="../css/component/cart-section.css" type="text/css" rel="stylesheet" >
	<link href="../css/component/menu-category.css" type="text/css" rel="stylesheet" >
    <link href="../css/component/menu-section.css" type="text/css" rel="stylesheet" >
	<link href="../css/component/search-header.css" type="text/css" rel="stylesheet" >

    <link href="../css/component.css" type="text/css" rel="stylesheet" >
    <link href="../css/buttons.css" type="text/css" rel="stylesheet" >
    <link href="../css/icon.css" type="text/css" rel="stylesheet" >
    <link href="../css/deco.css" type="text/css" rel="stylesheet" >
    
    <link href="../css/utils.css" type="text/css" rel="stylesheet" >    
</head>

<body>
    
    <!-- header 자리 -->
    <tiles:insertAttribute name="header" />	
    <!-- ---------------------------------------------------------------------- -->
    <!-- main 자리 -->
    <tiles:insertAttribute name="main" />   
	<!-- ---------------------------------------------------------------------- -->	
	<!-- footer 자리 -->
	<tiles:insertAttribute name="footer" />

</body>

</html>
