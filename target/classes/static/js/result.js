$(document).ready(function() {
    $('#addbudd').submit(function (event) {
        event.preventDefault();
        var buddy = {
            "firstName": $('input[name=firstName]').val(),
            "lastName": $('input[name=lastName]').val(),
            'phoneNumber': $('input[name=phoneNumber]').val(),
            'address': $('input[name=address]').val()
        };
        $.ajax({
            type: 'POST',
            url: "/book/1/add",
            data: JSON.stringify(buddy) ,
            contentType : "application/json; charset=utf-8",
            dataType: 'json'
        }).then(function (data) {
            var string = "<tr>"+
                "<td>" + data.firstName + "</td>" +
                "<td>" + data.lastName + "</td>" +
                "<td>" + data.phoneNumber + "</td>" +
                "<td>" + data.address + "</td></tr>";

            $('#products tr:last').
            after(string);
            console.log(data);
        })
    });
});