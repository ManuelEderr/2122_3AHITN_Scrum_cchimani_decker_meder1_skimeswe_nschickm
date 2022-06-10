package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author nschickm
 * FXML Controller class
 * <p>
 * Die Settings1.fxml Scene wird aufgerufen und dargestellt
 */
public class SplashController implements Initializable {

    @FXML
    private AnchorPane apane;
    private AnchorPane AnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        splash();
    }

    /**
     * Die Settings1.fxml Scene wird nach 2 Sekunden aufgerufen
     */
    private void splash() {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            AnchorPane = FXMLLoader.load(getClass().getResource("/FXML/Settings1.fxml"));
                            Stage stage = new Stage();
                            Scene scene = new Scene(AnchorPane);
                            scene.setFill(Color.TRANSPARENT);
                            stage.initStyle(StageStyle.TRANSPARENT);
                            stage.setTitle("Battleship");
                            stage.setScene(scene);
                            stage.setMinHeight(400);
                            stage.setMinWidth(255);
                            stage.show();
                            apane.getScene().getWindow().hide();
                        } catch (IOException ex) {
                            Logger.getLogger(SplashController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        }.start();
    }
}

/**
 * Stack Overflow
 * Products
 * Search…
 * user avatar
 * Manuel Eder
 * 1, 1 reputation
 * Home
 * PUBLIC
 * Questions
 * Tags
 * Users
 * Companies
 * COLLECTIVES
 * Explore Collectives
 * TEAMS
 * Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
 * Remove source file comments using IntelliJ?
 * Asked 12 years, 2 months ago
 * Modified 1 year, 8 months ago
 * Viewed 32k times
 *
 * 44
 *
 *
 * 37
 * Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..
 *
 * java
 * comments
 * intellij-idea
 * Share
 * Edit
 * Follow
 * edited May 23, 2017 at 12:26
 * user avatar
 * CommunityBot
 * 111 silver badge
 * asked Apr 10, 2010 at 12:59
 * user avatar
 * Marcus Leon
 * 53.1k115115 gold badges287287 silver badges420420 bronze badges
 * 2
 * Why not just run the Ant task in IntelliJ and call it a day? –
 * duffymo
 *  Apr 10, 2010 at 13:07
 * Duffymo that makes too much sense ;-) –
 * Marcus Leon
 *  Apr 10, 2010 at 14:02
 * Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
 * Marcus Leon
 *  Apr 11, 2010 at 16:07
 * This regex removes the stars: ^[ ]*/?\*+/?? –
        *EpicPandaForce
        *Jul 27,2016at 15:26
        *Add a comment
        *6Answers
        *Sorted by:
        *
        *Highest score(default)
        *
        *100
        *
        *You can use the"Replace"(or"Replace in Path"if you want to remove comments in multiple files)in the regular expression mode and then use this regular expression in the"Text to find"field:
        *
        *(/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        *and replace it with an empty string.Then press"All"to apply this replacement to the entire file or all the selected files.This will remove all block comments and line comments from your file.If you want only block comments to be removed,use this regex instead:
        *
        *(/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        *And if you want to just remove line comments,you can use this regex:
        *
        *([ \t]*//.*)
        *However,I should warn that this works only%99.99of times.You might have a string variable defined in your file like:
        *
        *String myStr="/** I am not a comment */";
        *This regex will turn this to:
        *
        *String myStr="";
        *Hope this helps.
        *
        *Share
        *Edit
        *Follow
        *edited Mar 11,2020at 6:25
        *user avatar
        *Umair
        *6,0781515gold badges4242 silver badges4848 bronze badges
        *answered Apr 10,2010at 15:53
        *user avatar
        *Behrang
        *44.5k2323 gold badges114114 silver badges153153 bronze badges
        *The first one?I just double checked it in IDEA9.0.1and it is working for me. –
        *Behrang
        *Apr 11,2010at 15:08
        *Hmmm..I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work.Any ideas?I'm on IntelliJ 8. –
        *Marcus Leon
        *Apr 11,2010at 16:11
        *Tried again,the second one works nicely..doesn't get all the comments but most. Still couldn't get the first to work. –
        *Marcus Leon
        *Apr 11,2010at 19:15
        *Every day what i want,i found Here(Stack over flow,Rocks)@intellij ,dont forget to check the,Regular Expression check box. –
        *Tushar Pandey
        *Jun 28,2013at 18:49
        *2
        *@marcus,you can select the proper context to make it 100%content.screencast.com/users/bulenkov/folders/Jing/media/… –
        *Konstantin Bulenkov
        *Sep 9,2014at 23:08
        *Show 4more comments
        *
        *21
        *
        *Late to the party but there is"Structural Search and Replace Dialogs"option that can be used to search different kind of comments and replace them
        *
        *Go to Edit=>Find=>Replace Structurally...
        *
        *Enter one of below in"Search Template:"
        *Single line
        *
        * // $CommentContent$
        *Multi line
        *
        * /*
 *   $CommentContent$
 * */
        *Javadoc
        *
        * /**
 *   $CommentContent$
 * */
        *Leave the"Replacement Template:"blank
        *
        *Select appropriate Scope
        *
        *Click'Find'and then'Replace all'
        *
        *you Should see no more comments
        *
        *Note:that this might mess up formatting so you will have to reformat affected code
        *
        *Share
        *Edit
        *Follow
        *answered May 19,2017at 16:20
        *user avatar
        *Prashant Bhate
        *10.6k77 gold badges4444 silver badges8181 bronze badges
        *best answer for me –
        *otaviodecampos
        *Jul 26,2017at 17:59
        *how do you do with xml comments?I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        *Fran Marzoa
        *Nov 19,2019at 13:58
        *This worked perfectly except for one instance.Cheers. –
        *Chris Smith
        *Jun 21,2020at 15:32
        *best answer.Worked for me really well. –
        *DevWithSigns
        *Jun 27,2021at 21:12
        *Add a comment
        *
        *8
        *
        *Press ctrl+r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.
        *
        *Share
        *Edit
        *Follow
        *answered Jan 20,2019at 9:21
        *user avatar
        *Blasanka
        *18.3k1010 gold badges8989 silver badges9696 bronze badges
        *This is a really nice solution.one thing to take into account,if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled.so be careful with it.maybe edit your regex to fit that scenario as well. –
        *Vasili Fedotov
        *Apr 14,2019at 11:20
        *In newer versions of IntelliJ,remember to click the.*button on the right of the text box to enable Regex mode to use this solution. –
        *Leponzo
        *Apr 25,2021at 4:10
        *Add a comment
        *
        *2
        *
        *The Comment Java Preprocessor allows to cut all commentaries from Java sources(the/R option)http://code.google.com/p/java-comment-preprocessor/
        *
        *Share
        *Edit
        *Follow
        *answered Dec 28,2012at 14:51
        *user avatar
        *Igor Maznitsa
        *74366silver badges1111 bronze badges
        *Add a comment
        *
        *1
        *
        *My solution is:
        *
        *find.-name*.java-type f-exec sh-c"perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        *Share
        *Edit
        *Follow
        *edited Aug 21,2014at 7:11
        *user avatar
        *McDowell
        *106k2929 gold badges196196 silver badges262262 bronze badges
        *answered Aug 21,2014at 6:53
        *user avatar
        *digua
        *1111bronze badge
        *This is the best one I found so far-I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        *Brad Parks
        *May 2,2021at 0:16
        *Add a comment
        *
        *0
        *
        *Press control+r to open replace and replace all box
        *
        *type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all
        *
        *That's it.
        *
        *Enjoy 😎
        *
        *Share
        *Edit
        *Follow
        *answered Sep 22,2020at 12:22
        *user avatar
        *Kaushik Borah
        *10111silver badge44 bronze badges
        *There are a few flaws in this idea. 1.It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere,including strings. 4.This is basically the same answer as Blasanka,almost 2years prior –
        *Gary
        *Sep 22,2020at 14:28
        *Add a comment
        *Your Answer
        *Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        *Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        *The Overflow Blog
        *The Great Decentralization?Geographic shifts and where tech talent is moving...
        *Want to be great at UX research?Take a cue from cultural anthropology(Ep. 451)
        *Featured on Meta
        *Announcing the arrival of Valued Associate #1214:Dalmarus
        *Improvements to site status and incident communication
        *Collectives Update:Introducing Bulletins
        *The[comma]tag is being burninated
        *Ask Wizard Test Results and Next Steps
        *Hot Meta Posts
        *13
        *Remove the[c2x]tag and replace it with[c23]
        *32people chatting
        *Meta Stack Overflow Comment Archive
        *1min ago-Boson-StandWithUkraine
        *Andrew T.:Dec 22at 7:45
        *Kevin B
        *Ryan M
        *VLAZ
        *Android
        *2hours ago-Pochmurnik
        *Pochmurnik:2hours ago
        *grrigore:2hours ago
        *W0MP3R:3hours ago
        *Ivan Milisavljevic:11hours ago
        *AdamMc331:17hours ago
        *WarrenFaith:18hours ago
        *Mark O'Sullivan: Jun 1 at 16:54
        *Linked
        *22
        *Is it possible to delete all comments in my code,in Android Studio?
        *8
        *How to remove all comments from the specific file in Android Studio?
        *5
        *Java:Removing comments from string
        *1
        *Script to remove comments in Java
        *2
        *How to strip blank and comment lines from text file during maven compile process?
        *1
        *Copy without comments in IntelliJ IDEA
        *1
        *Remove comments from a java file and maintain file structure
        *Related
        *1379
        *How can I permanently enable line numbers in IntelliJ?
        *8948
        *Can comments be used in JSON?
        *1570
        *Fastest way to determine if an integer's square root is an integer
        *1481
        *How do you do block comments in YAML?
        *1846
        *Comments in Markdown
        *1208
        *Which@NotNull Java annotation should I use?
        *692
        *Why are static variables considered evil?
        *434
        *IntelliJ-Convert a Java project/module into a Maven project/module
        *1334
        *How do I create multiline comments in Python?
        *1399
        *Why is executing Java code in comments with certain Unicode characters allowed?
        *Hot Network Questions
        *Is my non-standard outlet box grounding screw code-compliant?(US in 2022)
        *How to run scripts using python instead of python3?
        *Data race guarded by if(false)...what does the standard say?
        *Who were these characters?
        *A War on Three Fronts
        *How to determine fill limits when using different gauge wires
        *Has a weapon functionally equivalent to the AR-15been available for U.S.civilian purchase since 1907?
        *Can I buy my company internship laptop?Will they hunt me down if I keep it?
        *Photo Competition 2022-06-06:Reflections
        *Is this Poison Hemlock?
        *Which Linux kernel do I have in WSL?
        *I feel more comfortable working from an office.Is this now a'drawback'?
        *Are the rivers in my fantasy map accurate?
        *Mixing pineapple with Curd/Milk
        *Where is the original Dantzig Simplex 1947paper?
        *Is it possible to estimate my ELO without joining an organization or anything?
        *What would cause plants to survive on the ground while restricting animals to the air?
        *Is an archfiend's true name in their statblock?
        *Are protests in a democracy ethical?
        *Integration of Laplacian by parts
        *Should I Mix Paint from different machines for same room?
        *How to know what are commands,system calls,bash built-ins,etc?
        *Detecting overshoot lines in road network(flyovers,over/underpasses)in PostGIS
        *How to say expedite a process by two times
        *Question feed
        *
        *STACK OVERFLOW
        *Questions
        *Help
        *PRODUCTS
        *Teams
        *Advertising
        *Collectives
        *Talent
        *COMPANY
        *About
        *Press
        *Work Here
        *Legal
        *Privacy Policy
        *Terms of Service
        *Contact Us
        *Cookie Settings
        *Cookie Policy
        *STACK EXCHANGE NETWORK
        *Technology
        *Culture&recreation
        *Life&arts
        *Science
        *Professional
        *Business
        *API
        *Data
        *Blog
        *Facebook
        *Twitter
        *LinkedIn
        *Instagram
        *Site design/logo © 2022Stack Exchange Inc;user contributions licensed under cc by-sa.rev2022.6.8.42312
        *
        *Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312

        Stack Overflow
        Products
        Search…
        user avatar
        Manuel Eder
        1, 1 reputation
        Home
        PUBLIC
        Questions
        Tags
        Users
        Companies
        COLLECTIVES
        Explore Collectives
        TEAMS
        Stack Overflow for Teams – Start collaborating and sharing organizational knowledge.
        Remove source file comments using IntelliJ?
        Asked 12 years, 2 months ago
        Modified 1 year, 8 months ago
        Viewed 32k times

        44


        37
        Is there a plugin or tool in IntelliJ that will strip all comments out of your source .java files? I've read about an ANT task that can do this.. was looking to do the same from within the IDE. Alternatively a TextPad plugin would work as well..

        java
        comments
        intellij-idea
        Share
        Edit
        Follow
        edited May 23, 2017 at 12:26
        user avatar
        CommunityBot
        111 silver badge
        asked Apr 10, 2010 at 12:59
        user avatar
        Marcus Leon
        53.1k115115 gold badges287287 silver badges420420 bronze badges
        2
        Why not just run the Ant task in IntelliJ and call it a day? –
        duffymo
        Apr 10, 2010 at 13:07
        Duffymo that makes too much sense ;-) –
        Marcus Leon
        Apr 10, 2010 at 14:02
        Well it does make sense, I'd love to find a little IntelliJ plugin that I can use easily on any old file I open that I want to clear out the comments on. –
        Marcus Leon
        Apr 11, 2010 at 16:07
        This regex removes the stars: ^[ ]*/?\*+/? ? –
        EpicPandaForce
        Jul 27, 2016 at 15:26
        Add a comment
        6 Answers
        Sorted by:

        Highest score (default)

        100

        You can use the "Replace" (or "Replace in Path" if you want to remove comments in multiple files) in the regular expression mode and then use this regular expression in the "Text to find" field:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/|[ \t]*//.*)
        and replace it with an empty string. Then press "All" to apply this replacement to the entire file or all the selected files. This will remove all block comments and line comments from your file. If you want only block comments to be removed, use this regex instead:

        (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)
        And if you want to just remove line comments, you can use this regex:

        ([ \t]*//.*)
        However, I should warn that this works only %99.99 of times. You might have a string variable defined in your file like:

        String myStr = "/** I am not a comment */";
        This regex will turn this to:

        String myStr = "";
        Hope this helps.

        Share
        Edit
        Follow
        edited Mar 11, 2020 at 6:25
        user avatar
        Umair
        6,0781515 gold badges4242 silver badges4848 bronze badges
        answered Apr 10, 2010 at 15:53
        user avatar
        Behrang
        44.5k2323 gold badges114114 silver badges153153 bronze badges
        The first one? I just double checked it in IDEA 9.0.1 and it is working for me. –
        Behrang
        Apr 11, 2010 at 15:08
        Hmmm.. I'm trying on this pastebin.com/u0fQub8j file.. doesn't seem to work. Any ideas? I'm on IntelliJ 8. –
        Marcus Leon
        Apr 11, 2010 at 16:11
        Tried again, the second one works nicely.. doesn't get all the comments but most. Still couldn't get the first to work. –
        Marcus Leon
        Apr 11, 2010 at 19:15
        Every day what i want , i found Here ( Stack over flow , Rocks ) @intellij , dont forget to check the , Regular Expression check box . –
        Tushar Pandey
        Jun 28, 2013 at 18:49
        2
        @marcus, you can select the proper context to make it 100% content.screencast.com/users/bulenkov/folders/Jing/media/… –
        Konstantin Bulenkov
        Sep 9, 2014 at 23:08
        Show 4 more comments

        21

        Late to the party but there is "Structural Search and Replace Dialogs" option that can be used to search different kind of comments and replace them

        Go to Edit => Find => Replace Structurally...

        Enter one of below in "Search Template:"
        Single line

// $CommentContent$
        Multi line

/*
  $CommentContent$
*/
        Javadoc

/**
 $CommentContent$
 */
        Leave the "Replacement Template:" blank

        Select appropriate Scope

        Click 'Find' and then 'Replace all'

        you Should see no more comments

        Note: that this might mess up formatting so you will have to reformat affected code

        Share
        Edit
        Follow
        answered May 19, 2017 at 16:20
        user avatar
        Prashant Bhate
        10.6k77 gold badges4444 silver badges8181 bronze badges
        best answer for me –
        otaviodecampos
        Jul 26, 2017 at 17:59
        how do you do with xml comments? I'm trying to add <!-- $CommentContent$ --> but it says is malformed. –
        Fran Marzoa
        Nov 19, 2019 at 13:58
        This worked perfectly except for one instance. Cheers. –
        Chris Smith
        Jun 21, 2020 at 15:32
        best answer. Worked for me really well. –
        DevWithSigns
        Jun 27, 2021 at 21:12
        Add a comment

        8

        Press ctrl + r and in first textbox type //.*\n and then press replace all button. Then reformat the file by ctrl + alt + l.

        Share
        Edit
        Follow
        answered Jan 20, 2019 at 9:21
        user avatar
        Blasanka
        18.3k1010 gold badges8989 silver badges9696 bronze badges
        This is a really nice solution. one thing to take into account, if you have a comment on the last line of a comment block. /* /n // comment here */ your code can become jumbled. so be careful with it. maybe edit your regex to fit that scenario as well. –
        Vasili Fedotov
        Apr 14, 2019 at 11:20
        In newer versions of IntelliJ, remember to click the .* button on the right of the text box to enable Regex mode to use this solution. –
        Leponzo
        Apr 25, 2021 at 4:10
        Add a comment

        2

        The Comment Java Preprocessor allows to cut all commentaries from Java sources (the /R option) http://code.google.com/p/java-comment-preprocessor/

        Share
        Edit
        Follow
        answered Dec 28, 2012 at 14:51
        user avatar
        Igor Maznitsa
        74366 silver badges1111 bronze badges
        Add a comment

        1

        My solution is:

        find . -name *.java -type f -exec sh -c "perl -0pe 's#/\*(.|\n)*?\*/##g; s|//.*?\n|\n|g' '{}' > temp.java; cat temp.java > {} ; rm temp.java;" \;
        Share
        Edit
        Follow
        edited Aug 21, 2014 at 7:11
        user avatar
        McDowell
        106k2929 gold badges196196 silver badges262262 bronze badges
        answered Aug 21, 2014 at 6:53
        user avatar
        digua
        1111 bronze badge
        This is the best one I found so far - I just found that it left blank lines where the // were, so I played with it a bit and got this change to the perl bit: perl -0pe 's#/\*(.|\n)*?\*/##g; s|[^\S\r\n]*//.*?\n||g; s|//.*?\n|\n|g'  –
        Brad Parks
        May 2, 2021 at 0:16
        Add a comment

        0

        Press control + r to open replace and replace all box

        type //.* in first box, keep in second box empty and then select Regex. Select replace or replace all

        That's it.

        Enjoy 😎

        Share
        Edit
        Follow
        answered Sep 22, 2020 at 12:22
        user avatar
        Kaushik Borah
        10111 silver badge44 bronze badges
        There are a few flaws in this idea. 1. It won't strip comments in /* this form */. 2. I think the OP is looking to do this for all .java files, not just the currently opened one. 3. You need to turn on the filter 'In Comments', otherwise you'd blindly replace that pattern everywhere, including strings. 4. This is basically the same answer as Blasanka, almost 2 years prior –
        Gary
        Sep 22, 2020 at 14:28
        Add a comment
        Your Answer
        Links Images Styling/Headers Lists Blockquotes Code HTML TablesAdvanced help
        Not the answer you're looking for? Browse other questions tagged java comments intellij-idea or ask your own question.
        The Overflow Blog
        The Great Decentralization? Geographic shifts and where tech talent is moving...
        Want to be great at UX research? Take a cue from cultural anthropology (Ep. 451)
        Featured on Meta
        Announcing the arrival of Valued Associate #1214: Dalmarus
        Improvements to site status and incident communication
        Collectives Update: Introducing Bulletins
        The [comma] tag is being burninated
        Ask Wizard Test Results and Next Steps
        Hot Meta Posts
        13
        Remove the [c2x] tag and replace it with [c23]
        32 people chatting
        Meta Stack Overflow Comment Archive
        1 min ago - Boson - StandWithUkraine
        Andrew T.: Dec 22 at 7:45
        Kevin B
        Ryan M
        VLAZ
        Android
        2 hours ago - Pochmurnik
        Pochmurnik: 2 hours ago
        grrigore: 2 hours ago
        W0MP3R: 3 hours ago
        Ivan Milisavljevic: 11 hours ago
        AdamMc331: 17 hours ago
        WarrenFaith: 18 hours ago
        Mark O'Sullivan: Jun 1 at 16:54
        Linked
        22
        Is it possible to delete all comments in my code, in Android Studio?
        8
        How to remove all comments from the specific file in Android Studio?
        5
        Java: Removing comments from string
        1
        Script to remove comments in Java
        2
        How to strip blank and comment lines from text file during maven compile process?
        1
        Copy without comments in IntelliJ IDEA
        1
        Remove comments from a java file and maintain file structure
        Related
        1379
        How can I permanently enable line numbers in IntelliJ?
        8948
        Can comments be used in JSON?
        1570
        Fastest way to determine if an integer's square root is an integer
        1481
        How do you do block comments in YAML?
        1846
        Comments in Markdown
        1208
        Which @NotNull Java annotation should I use?
        692
        Why are static variables considered evil?
        434
        IntelliJ - Convert a Java project/module into a Maven project/module
        1334
        How do I create multiline comments in Python?
        1399
        Why is executing Java code in comments with certain Unicode characters allowed?
        Hot Network Questions
        Is my non-standard outlet box grounding screw code-compliant? (US in 2022)
        How to run scripts using python instead of python3?
        Data race guarded by if (false)... what does the standard say?
        Who were these characters?
        A War on Three Fronts
        How to determine fill limits when using different gauge wires
        Has a weapon functionally equivalent to the AR-15 been available for U.S. civilian purchase since 1907?
        Can I buy my company internship laptop? Will they hunt me down if I keep it?
        Photo Competition 2022-06-06: Reflections
        Is this Poison Hemlock?
        Which Linux kernel do I have in WSL?
        I feel more comfortable working from an office. Is this now a 'drawback'?
        Are the rivers in my fantasy map accurate?
        Mixing pineapple with Curd/Milk
        Where is the original Dantzig Simplex 1947 paper?
        Is it possible to estimate my ELO without joining an organization or anything?
        What would cause plants to survive on the ground while restricting animals to the air?
        Is an archfiend's true name in their statblock?
        Are protests in a democracy ethical?
        Integration of Laplacian by parts
        Should I Mix Paint from different machines for same room?
        How to know what are commands, system calls, bash built-ins, etc?
        Detecting overshoot lines in road network (flyovers, over/underpasses) in PostGIS
        How to say expedite a process by two times
        Question feed

        STACK OVERFLOW
        Questions
        Help
        PRODUCTS
        Teams
        Advertising
        Collectives
        Talent
        COMPANY
        About
        Press
        Work Here
        Legal
        Privacy Policy
        Terms of Service
        Contact Us
        Cookie Settings
        Cookie Policy
        STACK EXCHANGE NETWORK
        Technology
        Culture & recreation
        Life & arts
        Science
        Professional
        Business
        API
        Data
        Blog
        Facebook
        Twitter
        LinkedIn
        Instagram
        Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2022.6.8.42312


        */

