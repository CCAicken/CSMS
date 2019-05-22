/**t图片滚动 */
window.onload = function() {
    var odiv = document.getElementById('div-img');
    var oul = odiv.getElementsByTagName('ul')[0];
    var ali = oul.getElementsByTagName('li');
    var spa = -2;
    oul.innerHTML = oul.innerHTML + oul.innerHTML;
    oul.style.width = ali[0].offsetWidth * ali.length + 'px';

    function move() {
        if (oul.offsetLeft < -oul.offsetWidth / 2) {
            oul.style.left = '0';
        }
        if (oul.offsetLeft > 0) {
            oul.style.left = -oul.offsetWidth / 2 + 'px'
        }
        oul.style.left = oul.offsetLeft + spa + 'px';
    }
    var timer = setInterval(move, 30)

}

/**layui模块调取 */
layui.use(['element', 'carousel'], function() {
    var element = layui.element;
    var carousel = layui.carousel;
    //轮播
    carousel.render({
        elem: '#lb',
        width: '100%' //设置容器宽度
            ,
        height: 600,
        arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
    });
});