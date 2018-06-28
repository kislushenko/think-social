<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/style.css" >
</head>
<body class="bg-white">

<img src="image/Think.png" class="rounded mx-auto d-block">
<div class="mx-auto mt-2 shadow-lg p-4 bg-white" style="width: 300px;">
    <form>
        <div class="text-center">
            <h2>Login</h2>

        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="email" name="username" class="form-control"  id="email" aria-describedby="emailHelp" placeholder="Enter email">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" name="pass" class="form-control" id="password" placeholder="Password">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" formaction="/applogin" formmethod="post" class="btn btn-primary btn-lg btn-block">Login</button>
        <div class="text-center mt-1">
            <a href="/registration">Go to registration</a></div>
    </form>
</div>
<script src="js/jquery-3.3.1.slim.min.js" ></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

