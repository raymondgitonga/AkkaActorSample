package sample2;

import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import sample2.actors.MasterActor;

public class RunBasicActor {

    public static void main(String [] args){
        ActorSystem actorSystem = ActorSystem.create("basic-actor-system");

        ActorRef master = actorSystem.actorOf(Props.create(MasterActor.class));

        master.tell("Hey Tosh!!", Actor.noSender());

        actorSystem.terminate();
    }
}
