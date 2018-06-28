<#macro page>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/style.css" >

</head>
<body style="background: #b8b2b2">
<div class="bg-white w-100 mx-auto" >
<nav class="navbar navbar-light " style="background: #4304b0">
    <a class="navbar-brand" href="#">
        <img src="image/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
        Think
    </a>
    <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link" href="/">Link</a>
        </li>
    </ul>
</nav>
</div>
<div class="w-75 rounded-bottom mx-auto " style="height: 93vh;overflow: auto; background: #ffffff">
<#nested>
</div>
<script src="js/jquery-3.3.1.slim.min.js" ></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
</#macro>