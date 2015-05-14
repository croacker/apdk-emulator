package ru.peak.ml.apdk.ui.dialog;

import com.alee.extended.layout.TableLayout;
import com.alee.extended.panel.CenterPanel;
import com.alee.extended.panel.GroupPanel;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebDialog;
import com.alee.laf.text.WebTextField;
import com.alee.managers.hotkey.Hotkey;
import com.alee.managers.hotkey.HotkeyManager;
import com.alee.utils.SwingUtils;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class SettingsDialog extends WebDialog{

    @Getter @Setter
    boolean dialogResult = false;

    private WebTextField wtfServerAddress;
    private WebTextField wtfServerPort;

    private WebButton wbOk;
    private WebButton wbCancel;

    public String getServerAddress(){
        return wtfServerAddress.getText();
    }

    public void setServerAddress(String value){
        wtfServerAddress.setText(value);
    }

    public String getServerPort(){
        return wtfServerPort.getText();
    }

    public void setServerPor(String value){
        wtfServerPort.setText(value);
    }

    public SettingsDialog (Window owner )
    {
        super ( owner, "Параметры" );

        wtfServerAddress = new WebTextField( 15 );
        wtfServerPort = new WebTextField( 15 );

        setIconImages(WebLookAndFeel.getImages());
        setDefaultCloseOperation(WebDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        setModal(true);

        TableLayout layout = new TableLayout ( new double[][]{ { TableLayout.PREFERRED, TableLayout.FILL },
                { TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED } } );
        layout.setHGap(5);
        layout.setVGap(5);
        WebPanel content = new WebPanel ( layout );
        content.setMargin(15, 30, 15, 30);
        content.setOpaque(false);

        content.add(new WebLabel("IP-адрес сервера:", WebLabel.TRAILING), "0,0");
        content.add(wtfServerAddress, "1,0");

        content.add ( new WebLabel ( "Порт сервера:", WebLabel.TRAILING ), "0,1" );
        content.add (wtfServerPort, "1,1" );

        wbOk = new WebButton( "ОК" );
        wbOk.addActionListener(getCloseActionListener());

        wbCancel = new WebButton ( "Отмена" );
        wbCancel.addActionListener(getCloseActionListener());

        content.add(new CenterPanel(new GroupPanel(5, wbOk, wbCancel)), "0,2,1,2");
        SwingUtils.equalizeComponentsWidths(wbOk, wbCancel);

        add(content);

        HotkeyManager.registerHotkey(this, wbOk, Hotkey.ENTER);
        HotkeyManager.registerHotkey(this, wbCancel, Hotkey.ESCAPE);
    }

    private ActionListener getCloseActionListener(){
        return new ActionListener()
        {
            @Override
            public void actionPerformed ( ActionEvent e )
            {
                setDialogResult(e.getSource() == wbOk);
                close();
            }
        };
    }

    public void close(){
        setVisible ( false );
    }
}