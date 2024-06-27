<%@ include file="../init.jsp" %>

<%@ page import="java.util.ArrayList, java.util.List" %>
<%@ page import="java.util.Date" %>

<liferay-frontend:defineObjects />

<%
    class Game {
        private int appId;
        private String title;
        private String releaseDate;
        private String publisher;
        private double price;

        public Game(int appId, String title, String releaseDate, String publisher, double price) {
            this.appId = appId;
            this.title = title;
            this.releaseDate = releaseDate;
            this.publisher = publisher;
            this.price = price;
        }

        public int getAppId() {
            return appId;
        }

        public String getTitle() {
            return title;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public String getPublisher() {
            return publisher;
        }

        public double getPrice() {
            return price;
        }
    }

    List<Game> games = new ArrayList<>();
    games.add(new Game(730, "Counter-Strike 2", "21 Aug, 2012", "Valve", 0.0));
    games.add(new Game(570, "Dota 2", "9 Jul, 2013", "Valve", 0.0));
    games.add(new Game(2216430, "Ghost of Tsushima DIRECTOR'S CUT", "16 May, 2024", "PlayStation PC LLC", 3999.0));
    games.add(new Game(1245620, "ELDEN RING", "24 Feb, 2022", "FromSoftware Inc.", 3599.0));
    games.add(new Game(1091500, "Cyberpunk 2077", "9 Dec, 2020", "CD PROJEKT RED", 1499.0));
%>

<html>
<head>
    <title>Game Menu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .game-menu {
            width: 100%;
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .menu-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        .menu-header h1 {
            margin: 0;
        }

        .menu-header button {
            padding: 8px 16px;
            margin-left: 4px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .menu-header button:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f4f4f4;
        }

        td button {
            padding: 5px 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        td button:hover {
            background-color: #0056b3;
        }

        .pagination {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .pagination a {
            margin: 0 4px;
            padding: 5px 10px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .pagination a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="game-menu">
        <div class="menu-header">
            <h1>List of Games</h1>
            <div>
                <button onclick="location.href='#'">Add Game</button>
                <button onclick="location.href='#'">Publishers</button>
            </div>
        </div>
        <table>
            <thead>
                <tr>
                    <th>App ID</th>
                    <th>Title</th>
                    <th>Release Date</th>
                    <th>Publisher</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Game game : games) {
                %>
                <tr>
                    <td><%= game.getAppId() %></td>
                    <td><%= game.getTitle() %></td>
                    <td><%= game.getReleaseDate() %></td>
                    <td><%= game.getPublisher() %></td>
                    <td>$<%= game.getPrice() %></td>
                    <td>
                    	<button>Read</button>
                        <button>Edit</button>
                        <button>Delete</button>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <div class="pagination">
            <a href="#">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <span>...</span>
            <a href="#">10</a>
        </div>
    </div>
</body>
</html>