<%@ include file="../init.jsp" %>

<style>
    .game-table {
        width: 100%;
        border-collapse: collapse;
    }

    .game-table th, .game-table td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: left;
    }

    .game-table th {
        background-color: #f2f2f2;
        min-width: 150px;
    }

    .game-table td {
        min-width: 250px;
    }
</style>

<aui:fieldset>
    <h1 class="game-details">Game Details</h1>

    <aui:form>
        <table class="game-table">
            <tr>
                <th>App ID</th>
                <td>730</td>
            </tr>
            <tr>
                <th>Title</th>
                <td>Counter-Strike 2</td>
            </tr>
            <tr>
                <th>Release Date</th>
                <td>21 Aug, 2012</td>
            </tr>
            <tr>
                <th>Publisher</th>
                <td>Valve</td>
            </tr>
            <tr>
                <th>Price</th>
                <td>0.00</td>
            </tr>
            <tr>
                <th>About Description</th>
                <td>For over two decades, Counter-Strike has offered an elite competitive experience, one shaped by millions of players from across the globe. And now the next chapter in the CS story is about to begin. This is Counter-Strike 2.</td>
            </tr>
        </table>
    </aui:form>
</aui:fieldset>