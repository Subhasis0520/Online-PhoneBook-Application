<%@page import="util.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Edit Contact Details</title>
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
    <style>
      @media (min-width: 1025px) {
        .h-custom {
          height: 100vh !important;
        }
      }
    </style>
  </head>
  <body>
  <% User user = (User) session.getAttribute("user"); %>
  
    <section class="h-100 h-custom" style="background-color: #8fc4b7">
      <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-lg-8 col-xl-6">
            <div class="card rounded-3">
              <img
                src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
                class="w-100"
                style="
                  border-top-left-radius: 0.3rem;
                  border-top-right-radius: 0.3rem;
                "
                alt="Sample photo"
              />
              <div class="card-body p-4 p-md-5">
                <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">
                  Edit Contact Details
                </h3>

                <form class="px-md-2" action="update" method="post">
                  <div class="form-outline mb-4">
                  <input
                    type="number"
                    name="id"
                    value="<%= user.getId() %>"
                    hidden="true"
                  />
                    <input
                      type="text"
                      id="form3Example1q"
                      class="form-control"
                      name="name"
                      value="<%= user.getName() %>"
                    />
                    <label class="form-label" for="form3Example1q">Name</label>
                  </div>
                  <div class="form-outline mb-4">
                    <input
                      type="tel"
                      id="form3Example1q"
                      class="form-control"
                      name="phone"
                      value="<%= user.getPhone() %>"
                    />
                    <label class="form-label" for="form3Example1q">Phone</label>
                  </div>
                 
                  <button type="submit" class="btn btn-success btn-lg mb-1">
                    UPDATE
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- MDB -->
    <script
      type="text/javascript"
      src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"
    ></script>
  </body>
</html>