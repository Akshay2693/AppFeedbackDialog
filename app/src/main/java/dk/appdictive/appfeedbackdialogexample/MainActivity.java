package dk.appdictive.appfeedbackdialogexample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import dk.appdictive.feedbackdialog.rate_dialog.RateDialog;
import dk.appdictive.feedbackdialog.rate_dialog.RateDialogHelper;
import dk.appdictive.feedbackdialog.rate_dialog.RateDialogStrategy;
import dk.appdictive.feedbackdialog.rate_dialog.RateDialogTitle;
import dk.appdictive.feedbackdialog.rate_dialog.model.Email;

/**
 * Created by tobalr on 21-01-2015.
 */
public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new RateDialog(this,new RateDialogTitle("Title part one","Title part two"), new RateDialogStrategy() {
            @Override
            public void sendEmailFeedback() {
                Email email = new Email("test@test.com", "subject", "message");
                RateDialogHelper.openEmailProgramAndStartEmail(MainActivity.this, email);
            }

            @Override
            public void startGooglePlayForRating() {
                RateDialogHelper.openGooglePlayOnApp(MainActivity.this);

            }

            @Override
            public void onDismiss(DialogInterface dialog) {

            }
        }).show();
    }
}
