$(document).ready(function() {
doRemoteCall(null);
});

function doSearch(){
var city = $('#city').val();
doRemoteCall(city);
}

function doRemoteCall(city){
$("#atms tbody tr").remove();
let url=city?'/atms?city='+city:'/atms';
    $.ajax({
        url: url
    }).then(function(data) {
    let tdData='';
    data.map(item=>{
    let row='<tr><td>'+item.address.street+'</td><td>'+item.address.housenumber+'</td><td>'+item.address.postalcode+'</td><td>'+item.address.city+'</td></tr>';
     tdData= tdData+row;
    })
   $('#atms > tbody').append(tdData);

    });
}