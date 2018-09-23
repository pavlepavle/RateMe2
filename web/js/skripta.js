$(document).ready(function () {
    var counter = 0;

    $("#addrow").on("click", function () {
        var newRow = $("<tr>");
        var cols = "";

        cols += '<td><input type="text" class="form-control" required="required" name="name' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control" required="required" name="roleType' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control" required="required" name="roleName' + counter + '"/></td>';

        cols += '<td><input type="button" class="ibtnDel btn btn-md btn-danger "  value="Delete"></td>';
        newRow.append(cols);
        $("table.order-list").append(newRow);
        counter++;
        document.getElementById("brojUloga").value = counter;
    });



    $("table.order-list").on("click", ".ibtnDel", function (event) {
        $(this).closest("tr").remove();
        counter -= 1;
        document.getElementById("brojUloga").value = counter;
    });


});

function validateGenreAndRole() {

    checked = $("input[type=checkbox]:checked").length;
    
    num = $('input#brojUloga').val();
    
    if (checked){
        document.getElementById('text').innerHTML = '';
    }
    if (num>0){
        document.getElementById('text2').innerHTML = '';
    }
    
    if (!checked && num==0) {
        document.getElementById('text').innerHTML = 'At least one genre must be selected!';
        document.getElementById('text2').innerHTML = 'At least one role must be added!';
        return false;
    } else if(checked && num==0){
        document.getElementById('text2').innerHTML = 'At least one role must be added!';
        return false;
    } else if(!checked && num>0){
        document.getElementById('text').innerHTML = 'At least one genre must be selected!';
        return false;
    } else {
        return true;
    }

}

