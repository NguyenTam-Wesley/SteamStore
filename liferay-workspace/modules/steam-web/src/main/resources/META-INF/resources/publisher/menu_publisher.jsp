<%@ include file="../init.jsp" %>

<%@ page import="java.util.ArrayList, java.util.List" %>
<%@ page import="java.util.Date" %>

<liferay-frontend:defineObjects />

<%
    class Publisher {
        private String publisherId;
        private String publisherName;
        private String typicalGame;

        public Publisher(String publisherId, String publisherName, String typicalGame) {
            this.publisherId = publisherId;
            this.publisherName = publisherName;
            this.typicalGame = typicalGame;
        }

        public String getPublisherId() {
            return publisherId;
        }

        public String getPublisherName() {
            return publisherName;
        }

        public String getTypicalGame() {
            return typicalGame;
        }
    }

    List<Publisher> publishers = new ArrayList<>();
    publishers.add(new Publisher("valve", "Valve", "Counter-Strike 2"));
    publishers.add(new Publisher("playstationstudios", "PlayStation PC LLC", "Ghost of Tsushima DIRECTOR'S CUT"));
    publishers.add(new Publisher("BANDAINAMCO", "Bandai Namco Entertainment", "ELDEN RING"));
    publishers.add(new Publisher("CDPR", "CD PROJEKT RED", " Cyberpunk 2077"));
%>

<html>
<head>
    <title>Publisher Menu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .publisher-menu {
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
    <div class="publisher-menu">
        <div class="menu-header">
            <h1>List of Publishers</h1>
            <div>
                <button onclick="location.href='#'">Add Publisher</button>
                <button onclick="location.href='#'">Games</button>
            </div>
        </div>
        <table>
            <thead>
                <tr>
                    <th>Publisher ID</th>
                    <th>Publisher Name</th>
                    <th>Typical Games</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Publisher publisher : publishers) {
                %>
                <tr>
                    <td><%= publisher.getPublisherId() %></td>
                    <td><%= publisher.getPublisherName() %></td>
                    <td><%= publisher.getTypicalGame() %></td>
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
            <a href="#">4</a>
            <a href="#">5</a>
        </div>
    </div>
</body>
</html>
