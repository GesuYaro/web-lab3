function handleForm() {
    if(validate()) {
        $('.xMenu').eq(1).val(getX());
        $('.yInput').eq(1).val(getY());
        $('.mainSubmitButton').click();
    }
    return false;
}

function validate() {
    let validated = true;

    if (!validateX()) {
        $(".input-container:eq(0)").addClass("error-hovered");
        validated = false;
    } else {
        $(".input-container:eq(0)").removeClass("error-hovered");
    }

    if (!validateY()) {
        $(".input-container:eq(1)").addClass("error-hovered");
        validated = false;
    } else {
        $(".input-container:eq(1)").removeClass("error-hovered");
    }

    if (!validateR()) {
        $(".input-container:eq(2)").addClass("error-hovered");
        validated = false;
    } else {
        $(".input-container:eq(2)").removeClass("error-hovered");
    }

    return validated;
}

function validateX() {
    let x = getX();
    return !isNaN(x) && x >= -2 && x <= 1;
}

function validateY() {
    let y = getY();
    return !isNaN(y) && y >= -3 && y <= 3;
}

function validateR() {
    let r = getR();
    return !isNaN(r);
}

function getX() {
    let x = $('.xMenu').eq(0).val();
    return parseFloat(x.replace(',', '.'));
}

function getY() {
    let y = $('.yInput').eq(0).val();
    return parseFloat(y.replace(',', '.'));
}

function getR() {
    let r = $("[onchange='updateRadius(event)']").val();
    return parseFloat(r.replace(",", "."));
}