package org.rzo.yajsw.srvmgr.client;

import com.jeta.open.i18n.I18NUtils;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NewHostDialog extends JPanel
{
   JTextField _HOST = new JTextField();
   JLabel _MESSAGE = new JLabel();
   JTextField _PORT = new JTextField();
   JButton _CANCEL_BUTTON = new JButton();
   JButton _OK_BUTTON = new JButton();

   /**
    * Default constructor
    */
   public NewHostDialog()
   {
      initializePanel();
   }

   /**
    * Main method for panel
    */
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.setSize(600, 400);
      frame.setLocation(100, 100);
      frame.getContentPane().add(new NewHostDialog());
      frame.setVisible(true);

      frame.addWindowListener( new WindowAdapter()
      {
         public void windowClosing( WindowEvent evt )
         {
            System.exit(0);
         }
      });
   }

   /**
    * Adds fill components to empty cells in the first row and first column of the grid.
    * This ensures that the grid spacing will be the same as shown in the designer.
    * @param cols an array of column indices in the first row where fill components should be added.
    * @param rows an array of row indices in the first column where fill components should be added.
    */
   void addFillComponents( Container panel, int[] cols, int[] rows )
   {
      Dimension filler = new Dimension(10,10);

      boolean filled_cell_11 = false;
      CellConstraints cc = new CellConstraints();
      if ( cols.length > 0 && rows.length > 0 )
      {
         if ( cols[0] == 1 && rows[0] == 1 )
         {
            /** add a rigid area  */
            panel.add( Box.createRigidArea( filler ), cc.xy(1,1) );
            filled_cell_11 = true;
         }
      }

      for( int index = 0; index < cols.length; index++ )
      {
         if ( cols[index] == 1 && filled_cell_11 )
         {
            continue;
         }
         panel.add( Box.createRigidArea( filler ), cc.xy(cols[index],1) );
      }

      for( int index = 0; index < rows.length; index++ )
      {
         if ( rows[index] == 1 && filled_cell_11 )
         {
            continue;
         }
         panel.add( Box.createRigidArea( filler ), cc.xy(1,rows[index]) );
      }

   }

   /**
    * Helper method to load an image file from the CLASSPATH
    * @param imageName the package and name of the file to load relative to the CLASSPATH
    * @return an ImageIcon instance with the specified image file
    * @throws IllegalArgumentException if the image resource cannot be loaded.
    */
   public ImageIcon loadImage( String imageName )
   {
      try
      {
         ClassLoader classloader = getClass().getClassLoader();
         java.net.URL url = classloader.getResource( imageName );
         if ( url != null )
         {
            ImageIcon icon = new ImageIcon( url );
            return icon;
         }
      }
      catch( Exception e )
      {
         e.printStackTrace();
      }
      throw new IllegalArgumentException( "Unable to load image: " + imageName );
   }

   /**
    * Method for recalculating the component orientation for 
    * right-to-left Locales.
    * @param orientation the component orientation to be applied
    */
   public void applyComponentOrientation( ComponentOrientation orientation )
   {
      // Not yet implemented...
      // I18NUtils.applyComponentOrientation(this, orientation);
      super.applyComponentOrientation(orientation);
   }

   public JPanel createPanel()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:4DLU:NONE,FILL:143PX:NONE,FILL:120PX:NONE,FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:4DLU:NONE,CENTER:DEFAULT:NONE,CENTER:12DLU:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      JLabel jlabel1 = new JLabel();
      jlabel1.setFont(new Font("Tahoma",Font.BOLD,11));
      jlabel1.setText("Port");
      jpanel1.add(jlabel1,cc.xy(2,6));

      JLabel jlabel2 = new JLabel();
      jlabel2.setFont(new Font("Tahoma",Font.BOLD,12));
      jlabel2.setText("Add Host");
      jlabel2.setHorizontalAlignment(JLabel.CENTER);
      jpanel1.add(jlabel2,cc.xywh(2,2,4,1));

      JLabel jlabel3 = new JLabel();
      jlabel3.setFont(new Font("Tahoma",Font.BOLD,11));
      jlabel3.setText("Host");
      jpanel1.add(jlabel3,cc.xy(2,4));

      _HOST.setName("HOST");
      jpanel1.add(_HOST,cc.xywh(4,4,2,1));

      _MESSAGE.setName("MESSAGE");
      jpanel1.add(_MESSAGE,cc.xywh(2,9,4,1));

      _PORT.setName("PORT");
      jpanel1.add(_PORT,cc.xywh(4,6,2,1));

      jpanel1.add(createPanel1(),cc.xywh(2,8,4,1));
      addFillComponents(jpanel1,new int[]{ 1,2,3,4,5,6 },new int[]{ 1,2,3,4,5,6,7,8,9,10 });
      return jpanel1;
   }

   public JPanel createPanel1()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:93PX:NONE,FILL:89PX:NONE,FILL:22PX:NONE,FILL:87PX:NONE","CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      _CANCEL_BUTTON.setActionCommand("Cancel");
      _CANCEL_BUTTON.setName("CANCEL_BUTTON");
      _CANCEL_BUTTON.setText("CANCEL");
      jpanel1.add(_CANCEL_BUTTON,cc.xy(4,1));

      _OK_BUTTON.setActionCommand("OK");
      _OK_BUTTON.setName("OK_BUTTON");
      _OK_BUTTON.setText("ADD HOST");
      jpanel1.add(_OK_BUTTON,cc.xy(2,1));

      addFillComponents(jpanel1,new int[]{ 1,3 },new int[]{ 1 });
      return jpanel1;
   }

   /**
    * Initializer
    */
   protected void initializePanel()
   {
      setLayout(new BorderLayout());
      add(createPanel(), BorderLayout.CENTER);
   }


}
