function checkHit(event) {
    let x = ((event.pageX - $('#graphic').offset().left - 15 - 150) / 30 + 0.5).toFixed(2);
    let y = ((event.pageY - $('#graphic').offset().top - 15 - 150) / -30 - 0.5).toFixed(2);
    x = roundHalf(x);
    if (x > 1) {
        x = 1;
    }
    if (x < -2) {
        x = -2;
    }
    if (validateR()) {
        $('#rContainer').removeClass('error-hovered');
        $('.xMenu').val(x);
        $('.yInput').val(y);
        $('.submitButton').click();
    } else {
        $('#rContainer').addClass('error-hovered');
    }
}

function validateR() {
    let r = $("[onchange='updateRadius(event)']").val();
    r = parseFloat(r.replace(",", "."));
    return !isNaN(r);
}

function roundHalf(num) {
    return Math.round(num * 2) / 2;
}