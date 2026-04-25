import { printLog } from './utiles.js';


document.querySelector('#b2').addEventListener('click', () => {
    printLog("我被点击了...");
})

document.querySelector('#last').addEventListener('mouseenter', () => {
    printLog("鼠标移入了...");
})

document.querySelector('#last').addEventListener('mouseleave', () => {
    printLog("鼠标移出了...");
})      

document.querySelector('#username').addEventListener('keydown', () => { 
    printLog("键盘被按下了...");
})  

document.querySelector('#username').addEventListener('keyup', () => {
    printLog("键盘被抬起了...");
}
)
document.querySelector('#age').addEventListener('blur', () => {
    printLog("失去焦点...");
})          
document.querySelector('#age').addEventListener('focus', () => {    

    printLog("获得焦点...");
})

document.querySelector('#age').addEventListener('input', () => {
    printLog("用户输入时触发...");
})                  
document.querySelector('form').addEventListener('submit', () => {
    alert("表单被提交了...");
}       )


