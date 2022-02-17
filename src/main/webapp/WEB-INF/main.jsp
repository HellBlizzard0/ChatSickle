<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bootstrap Example</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="../css/style.css"/>

    </head>
    <body>
        <script>
            function switchChat(chatId) {
                console.log("switchChat(int): chatId = " + chatId);
               $.ajax({
                    url: "/switchChat",
                    type: 'POST',
                    timeout: 10000,
                    cache: false,
                    contentType: "application/json",
                    data: JSON.stringify({"chatId": chatId}),
                    dataType: "json",
                    success: function (data, textStatus, jqXHR) {
                        $(".mesgs").empty();
                        $(".mesgs").append("<h1>Success!</h1></br>Now go and finish up your code.")
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        console.log("Failed: " + textStatus);
                    }
                });
            }
            function sendMessage(chatId) {
                var message = $("#messageInputId").val();
                console.log("chatId = " + chatId);
                console.log("message = " + message);
                console.log({"chatId": chatId, "body": message});
                $.ajax({
                    url: "/sendMessage",
                    type: 'POST',
                    timeout: 10000,
                    cache: false,
                    contentType: "application/json",
                    data: JSON.stringify({"chatId": chatId, "body": message}),
                    dataType: "text",
                    success: function (data, textStatus, jqXHR) {
                        $("form").submit();
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        console.log("Failed: " + errorThrown);
                    }
                });
            }

        </script>
        <form action="/">
        </form>
        <div class="messaging">
            <div class="inbox_msg">
                <div class="inbox_people">
                    <div class="headind_srch">
                        <div class="recent_heading">
                            <h4>Recent</h4>
                        </div>
                        <div class="srch_bar">
                            <div class="stylish-input-group">
                                <input type="text" class="search-bar"  placeholder="Search" >
                            </div>
                        </div>
                    </div>
                    <div class="inbox_chat scroll">
                        <c:forEach items="${chats}" var="chat">
                            <div class="chat_list active_chat" onclick="switchChat(${chat.id})">
                                <div class="chat_people">
                                    <div class="chat_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                                    <div class="chat_ib">
                                        <h5>${chat.otherUser.name} <span class="chat_date">Dec 25</span></h5>
                                        <p>Test, which is a new approach to have all solutions
                                            astrology under one roof.</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="mesgs">
                    <div class="msg_history">
                        <c:forEach items="${chats.get(0).messages}" var="message">
                            <c:if test="${message.initUser.id == chats.get(0).initUser.id}">
                                <div class="outgoing_msg">
                                    <div class="sent_msg">
                                        <p>${message.body}</p>
                                        <span class="time_date"> 11:01 AM    |    June 9</span> </div>
                                </div>
                            </c:if>
                            <c:if test="${message.initUser.id != chats.get(0).initUser.id}">
                                <div class="incoming_msg">
                                    <div class="incoming_msg_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                                    <div class="received_msg">
                                        <div class="received_withd_msg">
                                            <p>${message.body}</p>
                                            <span class="time_date"> 11:01 AM    |    Yesterday</span>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>>
                    </div>
                    <div class="type_msg">
                        <div class="input_msg_write">
                            <input type="text" class="write_msg" placeholder="Type a message" id="messageInputId"/>
                            <button class="msg_send_btn" type="button" onclick="sendMessage(${chats.get(0).id})"><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>