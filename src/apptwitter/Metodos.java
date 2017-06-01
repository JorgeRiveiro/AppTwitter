/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptwitter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.*;

import twitter4j.conf.ConfigurationBuilder;
/**
 *
 * @author Jorge
 */
public class Metodos {
    
    static ConfigurationBuilder cb;
    static Twitter twitter;
    static Status estado;
    static DirectMessage mensaje;
    static ArrayList <Status> tweets = new ArrayList<Status>();
    static Iterator <Status>it = tweets.iterator();
    
    
   
  /**
   * acceso con tokens
   */ 
     
    
    public static void acceso(){
        
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();

            
    }
/**
 * timeline linea de tempo twitts
 */
    public static void timeLine () {

        List<Status> statuses;

        try {
            statuses= twitter.getHomeTimeline();
            for (twitter4j.Status estado : statuses) {
                System.out.println(estado.getUser().getName() + ":"
                        + estado.getText());
                tweets.add(estado);
            }
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(apptwitter.AppTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
/**
 * novo tweet
 * @param publicacion texto do tweet
 */
   public static void twitear(String publicacion) {
    try {
            estado = twitter.updateStatus(publicacion);
            System.out.println("Publicacion -> [" + estado.getText() + "].");
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
}

/**
 * Busca os trending topic
 * 
 * @param buscar palabra a buscar
 */
    public static void buscarTt(String buscar) {

        QueryResult result;
        try {
           Query query = new Query(JOptionPane.showInputDialog("Buscar: "));
            result=twitter.search(query);
            for (twitter4j.Status statuse : result.getTweets()) {
            System.out.println("@" + statuse.getUser().getScreenName() + ":" + statuse.getText());
            }
        }catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(apptwitter.AppTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * enviarMp envia mensaxe privado
     * 
     *
     * @param destinatario perfil ao que vai destinado o MP
     * 
     * @param mensaxe texto do mensaxe
     */
   public static void enviarMP(String destinatario, String mensaxe) {

        try {

            Metodos.mensaje = twitter.sendDirectMessage(destinatario, mensaxe);
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Enviar: " + Metodos.mensaje.getText() + " a @" + Metodos.mensaje.getRecipientScreenName());

    }
}
