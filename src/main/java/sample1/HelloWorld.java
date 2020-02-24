package sample1;


import akka.actor.typed.ActorSystem;

public class HelloWorld {

    public static void main(String [] args){
        ActorSystem<App.Command> mySystem = ActorSystem.create(App.create(), "MySystem");

        mySystem.tell(App.SayHello.INSTANCE);
        mySystem.tell(App.SayHello.INSTANCE);
        mySystem.tell(new App.ChangeMessage("Hello Actor world"));
        mySystem.tell(App.SayHello.INSTANCE);
        mySystem.tell(App.SayHello.INSTANCE);
    }
}
