function ajaxDelete(url) {
    return ajaxData(url, null, {
        method: 'delete',
        beforeSend: function (xhr) {
            xhr.setRequestHeader(_csrf.header, _csrf.token)
        }
    });
}

function ajaxData(url, data, option) {
    var deferred = $.Deferred();
    console.log(url);
    console.log(data);

    var options = {
        url: url,
        method: 'post',
        data: data,
        dataType: 'json',
        success: function (data) {
            console.log(data);
            deferred.resolve(data);
        },
        error: function (result) {
            deferred.reject(result);
        }
    };

    for (var k in option)
        if (option.hasOwnProperty(k))
            options[k] = option[k];

    $.ajax(options);

    return deferred.promise();
}