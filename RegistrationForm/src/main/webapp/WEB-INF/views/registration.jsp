<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='UTF-8'>
    <title></title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script type="text/javascript">
        <%@include file="/WEB-INF/views/script.js"%>
    </script>
</head>
<body class="d-flex justify-content-center align-items-center flex-column" style="height: 100vh">
<form action="" method="post">
    <h1 class="text-center align-items-center">Sign up</h1>
    <div class="form-group">
        <div class="d-flex flex-column">
            <label class="" for="name">Name</label>
            <input type="text" class="form-control-sm" id="name" name="name" placeholder="name" required>
        </div>
    </div>
    <div class="form-group">
        <div class="d-flex flex-column">
            <label class="" for="email">Email</label>
            <input type="email" class="form-control-sm" id="email" name="email" placeholder="email" required>
        </div>
    </div>
    <div class="form-group">
        <div class="d-flex flex-column">
            <label class="" for="password">Password</label>
            <input type="password" class="form-control-sm" id="password" name="password"
                   placeholder="password" required>
        </div>
    </div>
    <div class="form-group">
        <div class="d-flex flex-column">
            <label class="" for="confirm_password">Confirm password</label>
            <input type="password" class="form-control-sm" id="confirm_password" name="confirm_password"
                   placeholder="confirm password" required>
        </div>
    </div>
    <div>
        <input type="checkbox" class="form-check-input mx-1" id="consent" name="consent" required>
        <label class="form-check-label mx-4 mb-3" for="consent">Consent to personal data processing</label>
    </div>
    <button type="submit" class="btn btn-secondary">Sign up</button>
    <p></p>
    <%--@elvariable id="message" type=""--%>
    <c:if test="${not empty message}">
        <h6 class="mx-3">${message}</h6>
    </c:if>
</form>
</body>
</html>