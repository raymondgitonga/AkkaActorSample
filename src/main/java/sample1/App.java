package sample1;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class App extends AbstractBehavior<App.Command> {

    private App(ActorContext<Command> context) {
        super(context);
    }

    public  static Behavior<Command> create(){
        return Behaviors.setup(context -> new App(context));
    }

    interface Command {}

    public enum SayHello implements Command {
        INSTANCE
    }

    public static class ChangeMessage implements Command {
        public final String newMessage;

        public ChangeMessage(String newMessage) {
            this.newMessage = newMessage;
        }
    }

    private String message = "Hello AKKA";

    @Override
    public Receive<Command> createReceive() {
        return newReceiveBuilder()
                .onMessageEquals(SayHello.INSTANCE, this::onSayHello)
                .onMessage(ChangeMessage.class, this::onChangeMessage)
                .build();
    }

    private Behavior<Command> onChangeMessage(ChangeMessage command) {
        message = command.newMessage;
        return this;
    }

    private Behavior<Command> onSayHello() {
        System.out.println(message);

        return this;
    }
}
