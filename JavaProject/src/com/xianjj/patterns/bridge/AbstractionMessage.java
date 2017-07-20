package com.xianjj.patterns.bridge;

/**
 * JavaProject
 * Created by xian.juanjuan on 2017-7-20 13:51.
 */

/**
 * 消息类型抽象化接口:例如：普通消息，紧急消息
 */
public abstract class AbstractionMessage {
    MessageImplementor impl;

    public AbstractionMessage(MessageImplementor impl) {
        this.impl = impl;
    }

    public void sendMessage(String message, String toUser){
        impl.send(message, toUser);
    }
}

/**
 * 发送普通消息-修正消息类型抽象化接口1
 */
class CommonMessage extends AbstractionMessage{
    public CommonMessage(MessageImplementor impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        super.sendMessage(message, toUser);//普通消息调用父类接口即可
    }
}

/**
 * 发送紧急消息-修正消息类型抽象化接口2
 */
class UrgencyMessage extends AbstractionMessage{
    public UrgencyMessage(MessageImplementor impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "紧急—" + message;
        super.sendMessage(message, toUser);
    }
    //紧急消息在普通消息的基础上增加新功能
    public void replyMessage(){
        System.out.println("收到紧急消息");
    }
}

/**
* 发送消息实现化接口-发送方式
*/
interface MessageImplementor{
    void send(String message, String toUser);
}


/**
 * 发送手机短信-实现化接口具体实现1
 */
class MessageSMS implements MessageImplementor{
    @Override
    public void send(String message, String toUser) {
        System.out.println("收到短信消息："+toUser+"，"+message);
    }
}

/**
 * 发送邮件-实现化接口具体实现2
 */
class MessageEmail implements MessageImplementor{
    @Override
    public void send(String message, String toUser) {
        System.out.println("收到邮件消息："+toUser+"，"+message);
    }
}

class MessageClient{
    public static void main(String[] args){
        MessageImplementor impl = new MessageSMS();
        AbstractionMessage message = new CommonMessage(impl);
        message.sendMessage("今年国庆假期按照国家法定假日休假", "全体同事");
        message = new UrgencyMessage(impl);
        message.sendMessage("本周末召开紧急会议，各部门leader收到请回复", "各部门leader");
        // 实现方式切换为邮件方式
        impl = new MessageEmail();
        message = new CommonMessage(impl);
        message.sendMessage("今年国庆假期按照国家法定假日休假", "全体同事");
        message = new UrgencyMessage(impl);
        message.sendMessage("本周末召开紧急会议，各部门leader收到请回复", "各部门leader");
    }
}
