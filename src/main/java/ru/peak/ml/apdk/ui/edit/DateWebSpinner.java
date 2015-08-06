package ru.peak.ml.apdk.ui.edit;

import com.alee.laf.spinner.WebSpinner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.Calendar;

/**
 *
 */
@Component
@Slf4j
@Scope("prototype")
public class DateWebSpinner extends WebSpinner {

    @SuppressWarnings("unchecked")
    @PostConstruct
    private void initComponents(){
        SpinnerDateModel model = new SpinnerDateModel ();
        model.setCalendarField(Calendar.MINUTE);
        setModel(model);
        setEditor(new JSpinner.DateEditor(this, "dd/MM/yyyy HH:mm:ss"));
    }

}
