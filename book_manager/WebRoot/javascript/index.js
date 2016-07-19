

;(function () {
    // alert(12);
    var userImg = document.querySelector('.user-img');
    var psdImg = document.querySelector('.psd-img');
    var user = document.querySelector('#user');
    var psd = document.querySelector('#psd');
    var reg = /\s/g;
    user.addEventListener('blur', function () {
        var userText = user.value;
        userText = userText.replace(reg, '');
        if (userText == '') {
            userImg.style.display = 'inline-block';
        } else {
            userImg.style.display = 'none';
        }
    }, false);
    psd.addEventListener('blur', function () {
        var psdText = psd.value;
        psdText = psdText.replace(reg, '');
        if (psdText == '') {
            psdImg.style.display = 'inline-block';
        } else {
            psdImg.style.display = 'none';
        }
    }, false);

})();









