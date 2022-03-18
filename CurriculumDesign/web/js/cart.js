function add(id){
    var text=document.getElementById("goods_number_"+id);
    var span_totalPrice=document.getElementById("totalPrice_"+id);
    var number=parseInt(text.value);
    var price=parseFloat(document.getElementById("price_"+id).innerHTML.replace("￥",""));
    number++;
    text.value=number;
    span_totalPrice.innerHTML="￥"+(price*number).toString()+".0";
    console.log(text.value);
}

function sub(id){
    var subButton=document.getElementsByClassName("btn_sub");
    var text=document.getElementById("goods_number_"+id);
    var span_totalPrice=document.getElementById("totalPrice_"+id);
    var number=parseInt(text.value);
    var price=parseFloat(document.getElementById("price_"+id).innerHTML.replace("￥",""));
    if (number>1)
        number--;
    else{
        subButton.disable=false;
    }
    text.value=number;
    span_totalPrice.innerHTML="￥"+(price*number).toString()+".0";
}



function selectAll(){
    var span_totalNumber=document.getElementById("totalNumber");
    var span_total_price=document.getElementById("totalPrice");
    var span_goods_price=document.getElementsByClassName("oneClass_totalPrice");
    var input_goods_number=document.getElementsByClassName("goods_number");
    var allCheckbox=document.getElementsByClassName("checkbox");
    var selectAll=document.getElementById("checkboxAll")
    if (selectAll.checked) {
        for (var i = 0; i < allCheckbox.length; i++) {
            allCheckbox[i].checked = true;
        }

        var totalPrice = 0.0;
        var totalNumber=0;
        for (var i = 0; i < span_goods_price.length; i++) {
            totalPrice+=parseFloat(span_goods_price[i].innerHTML.replace("￥",""));
            totalNumber+=parseInt(input_goods_number[i].value);
        }
        span_total_price.innerHTML="￥"+totalPrice+".0";
        span_totalNumber.innerHTML=""+totalNumber;
    }
    else{
        for (var i=0;i<allCheckbox.length;i++){
            allCheckbox[i].checked=false;
        }
        span_total_price.innerHTML="￥0.0";
        span_totalNumber.innerHTML="0";
    }
}

function oneCheckbox(id){
    var span_totalNumber=document.getElementById("totalNumber");
    var span_total_price=document.getElementById("totalPrice");
    var span_goods_price=document.getElementById("totalPrice_"+id);
    var span_goods_number=document.getElementById("goods_number_"+id);
    var checkbox=document.getElementById("checkbox_"+id);
    var allCheckbox=document.getElementsByClassName("checkbox");
    var selectAll=document.getElementById("checkboxAll")
    var isSelectedAll=true;
    for (var i=0;i<allCheckbox.length;i++){
        if(allCheckbox[i].checked==false){
            isSelectedAll=false;
            break;
        }
    }
    if (isSelectedAll==true)
        selectAll.checked=true;
    else
        selectAll.checked=false;

    var originPrice=parseFloat(span_total_price.innerHTML.replace("￥",""));
    var currentPrice=parseFloat(span_goods_price.innerHTML.replace("￥",""));
    var originNumber=parseInt(span_totalNumber.innerHTML);
    var currentNumber=parseInt(span_goods_number.value);
    if (checkbox.checked){
        span_total_price.innerHTML="￥"+(originPrice+currentPrice)+".0";
        span_totalNumber.innerHTML=""+(originNumber+currentNumber);
    }else if(originPrice>0){
        span_total_price.innerHTML="￥"+(originPrice-currentPrice)+".0";
        span_totalNumber.innerHTML=""+(originNumber-currentNumber);
    }
}

function deleteCartItem(id){
    if(confirm("确认删除吗？"))
        window.open("DeleteCartItemServlet?id="+id,"_self");
    return false;
}

function emptyCart(){
    if(confirm("确认清空购物车吗？"))
        window.open("DeleteCartItemServlet","_self");
    return false;
}