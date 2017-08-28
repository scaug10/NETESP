    function moveselect(obj,target,all){
        if (!all) all=0
        if (obj!="[object]") obj=eval("document.all."+obj)
        target=eval("document.all."+target)
        if (all==0)
        {
            while (obj.selectedIndex>-1){
                //alert(obj.selectedIndex)
                mot=obj.options[obj.selectedIndex].text
                mov=obj.options[obj.selectedIndex].value
                obj.remove(obj.selectedIndex)
                var newoption=document.createElement("OPTION");
                newoption.text=mot
                newoption.value=mov
                target.add(newoption)
            }
        }
        else
        {
            //alert(obj.options.length)
            for (i=0;i<obj.length;i++)
            {
                mot=obj.options[i].text
                mov=obj.options[i].value
                var newoption=document.createElement("OPTION");
                newoption.text=mot
                newoption.value=mov
                target.add(newoption)
            }
            obj.options.length=0
        }
    }
function dakai(){
    document.getElementById('light').style.display='block';
    document.getElementById('fade').style.display='block'
}
function guanbi(){
//把右边select的值传到文本框内
    var yuanGong=document.getElementById("StrategyClassification")
    yuanGong.value=""//如果不加这句，则每次选择的结果追加
    var huoQu=document.getElementById("D2")
    for(var k=0;k<huoQu.length;k++)
        yuanGong.value=yuanGong.value + huoQu.options[k].value + " "//" "中间为空格，字符分隔符，可以改成别的
    document.getElementById('light').style.display='none';
    document.getElementById('fade').style.display='none'
}