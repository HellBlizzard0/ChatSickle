/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function sendMessage(chatId) {
    var message = $("#messageInputId").val();
    $.ajax({
        url: "/sendMessage",
        data: {"chatId": chatId, "body": message},
        dataType: "text",
        success: function (data, textStatus, jqXHR) {
            console.log("Success: " + data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Failed: " + errorThrown);
        }
    });
}
