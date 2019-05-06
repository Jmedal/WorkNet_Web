//字数限制 
function checkLength(which,num) {
    if(num=="1"){
        document.getElementById("chLeft_remark").innerHTML = wordRestrict(which,200).toString();
        $('#prompt').css('display','block');
    }
}
function wordRestrict(which,maxChars){
    var curr;
    if (which.value.length > maxChars)
    which.value = which.value.substring(0,maxChars);
    curr = maxChars - which.value.length;
    return curr;
}