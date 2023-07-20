<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Search Navbar</title>
    <style>
      /* styles.css */

      /* Basic styling for the navigation */
      .search-navbar {
        background-color: rgba(0, 0, 0, 0.954);
        padding: 15px;
      }

      /* Styling for the search form */
      .search-form {
        display: flex;
        align-items: center;
      }

      /* Styling for the search input */
      .search-input {
        padding: 5px;
        margin-left: 60%;
        border: 1px solid #ccc;
        border-radius: 5px;
        outline: none;
        font-size: 20px;
      }

      /* Styling for the search button */
      .search-button {
        margin-left: 10px;
        padding: 5px 10px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 20px;
      }

      /* Hover effect for the search button */
      .search-button:hover {
        background-color: #0056b3;
      }
    </style>
  </head>
  <body>
    <nav class="search-navbar">
      <form class="search-form" action="search" method="post">
        <input type="text" class="search-input" placeholder="Search By Name" name="name" />
        <button type="submit" class="search-button">Search</button>
      </form>
    </nav>
  </body>
</html>
