<%@page import="util.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>User</title>
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
      rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
      href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
      rel="stylesheet"
    />
    <!-- MDB -->
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css"
      rel="stylesheet"
    />
    <style type="text/css">
      .ab{
        color: red;
        text-align: center;
        background-color: white;
        margin-top: 7%;
      }
    </style>
  </head>
  <body>
  <% 
      User u = (User) session.getAttribute("u");
      String em = (String) session.getAttribute("email");
      if(em.equals(u.getEmail())){
  %>
    <section class="vh-100" style="background-color: #eee">
      <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-md-12 col-xl-4">
            <div class="card" style="border-radius: 15px">
              <div class="card-body text-center">
                <div class="mt-3 mb-4">
                  <img
                    src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2-bg.webp"
                    class="rounded-circle img-fluid"
                    style="width: 100px"
                  />
                </div>
                <h4 class="mb-2"> <%= u.getName() %> </h4>
                <p class="text-muted mb-4"> <%= u.getPhone() %> </p>
                <div class="mb-4 pb-2">
                  <button
                    type="button"
                    class="btn btn-outline-primary btn-floating"
                  >
                    <i class="fab fa-facebook-f fa-lg"></i>
                  </button>
                  <button
                    type="button"
                    class="btn btn-outline-primary btn-floating"
                  >
                    <i class="fab fa-twitter fa-lg"></i>
                  </button>
                  <button
                    type="button"
                    class="btn btn-outline-primary btn-floating"
                  >
                    <i class="fab fa-skype fa-lg"></i>
                  </button>
                </div>
                <button
                  type="button"
                  class="btn btn-primary btn-rounded btn-lg"
                >
                  Call me
                </button>
                <div
                  class="d-flex justify-content-between text-center mt-5 mb-2"
                ></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
   <%  
      }else{
   %>
     <h1 class="ab"> NO USER FOUND</h1>
   <% } %>
    <script
      type="text/javascript"
      src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"
    ></script>
  </body>
</html>
