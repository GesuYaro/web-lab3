function time() {
    $("#clock").load(location.href + " #clock");
}
setInterval(time, 9000);