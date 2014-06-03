package Application;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

public class MainScreen extends javax.swing.JFrame {

	public MainScreen() {
		initComponents();

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});

		entries = new ArrayList<Entry>();
		listModel = new DefaultListModel<String>();
		listEntries.setModel(listModel);
		loadPreviousLog();

		logContent = new StringBuilder();
		insertEntry = new InsertEntry(this);
		timer = new ScheduledThreadPoolExecutor(4);
		timer.scheduleAtFixedRate(new UpdateTime(), 0, 1, TimeUnit.SECONDS);
		timer.scheduleAtFixedRate(new AutoSave(), 0, 15, TimeUnit.SECONDS);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		taContent = new javax.swing.JTextArea();
		tfTitle = new javax.swing.JTextField();
		jScrollPane2 = new javax.swing.JScrollPane();
		bSave = new javax.swing.JButton();
		listEntries = new JList<String>();
		lNumberOfItems = new javax.swing.JLabel();
		lTime = new javax.swing.JLabel();
		lDate = new javax.swing.JLabel();
		bNew = new javax.swing.JButton();
		mbMain = new javax.swing.JMenuBar();
		mFile = new javax.swing.JMenu("File");
		mEdit = new JMenu("Edit");
		mOption = new JMenu("Option");
		miPreview = new javax.swing.JMenuItem();
		miSaveToFile = new javax.swing.JMenuItem();
		miLoad = new javax.swing.JMenuItem();
		miNew = new javax.swing.JMenuItem();
		jSeparator1 = new javax.swing.JPopupMenu.Separator();
		miExit = new javax.swing.JMenuItem();
		miFind = new JMenuItem();
		lFind = new JLabel("Find");
		tfFind = new JTextField();
		cbmiIncrementalSearch = new JCheckBoxMenuItem("Incremental search");
		searchHighLight = new DefaultHighlighter();
	    highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		taContent.setHighlighter(searchHighLight);
		taContent.setColumns(20);
		taContent.setLineWrap(true);
		taContent.setRows(5);
		taContent.setWrapStyleWord(true);
		taContent.setDragEnabled(true);
		taContent.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(java.awt.event.KeyEvent evt) {
				taContentKeyReleased(evt);
			}
		});
		jScrollPane1.setViewportView(taContent);

		tfTitle.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
		tfTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		tfTitle.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(java.awt.event.KeyEvent evt) {
				tfTitleKeyReleased(evt);
			}
		});

		tfFind.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER || cbmiIncrementalSearch.isSelected()) {
					ArrayList<Integer> filtered = Entry.find(MainScreen.this.entries, MainScreen.this.tfFind.getText());
					
					listModel.clear();
					
					for (Integer i : filtered) {
						listModel.addElement(entries.get(i));
					}
					updateNumberOfItems();
				}
			}
		});
		
		listEntries.setModel(new AbstractListModel() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "6", "7", "8",
					"9", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "1", "2", "3", "4",
					"5", "6", "7", "8", "9", "0" };

			@Override
			public int getSize() {
				return strings.length;
			}

			@Override
			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		listEntries.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		listEntries.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				listEntriesMouseClicked(evt);
			}
		});
		listEntries.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				listEntriesKeyPressed(evt);
			}
		});
		jScrollPane2.setViewportView(listEntries);

		bSave.setText("Save");
		bSave.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bSaveActionPerformed(evt);
			}
		});

		lNumberOfItems.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lNumberOfItems.setText("Number Of Item");

		lTime.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
		lTime.setText("Current Time");

		lDate.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
		lDate.setText("Current Date");

		bNew.setText("New Entry");
		bNew.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bNewActionPerformed(evt);
			}
		});

		miFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
		miFind.setText("Find");
		miFind.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miFindActionPerformed(evt);
			}
		});
		mEdit.add(miFind);
		
		miNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
		miNew.setText("New entry");
		miNew.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				insertEntry.setVisible(true);
			}
		});
		mFile.add(miNew);
		
		miPreview.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
		miPreview.setText("Preview Log");
		miPreview.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miPreviewActionPerformed(evt);
			}
		});
		mFile.add(miPreview);

		miSaveToFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
		miSaveToFile.setText("Save to file");
		miSaveToFile.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miSaveToFileActionPerformed(evt);
			}
		});
		mFile.add(miSaveToFile);

		miLoad.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L,
				java.awt.event.InputEvent.CTRL_MASK));
		miLoad.setText("Load Previous Log");
		miLoad.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miLoadActionPerformed(evt);
			}
		});
		mFile.add(miLoad);
		mFile.add(jSeparator1);

		miExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X,
				java.awt.event.InputEvent.ALT_MASK));
		miExit.setText("Exit");
		miExit.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miExitActionPerformed(evt);
			}
		});
		mFile.add(miExit);
		
		cbmiIncrementalSearch.setSelected(true);
		mOption.add(cbmiIncrementalSearch);
		
		mbMain.add(mFile);
		mbMain.add(mEdit);
		mbMain.add(mOption);
		setJMenuBar(mbMain);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(225, 225, 225)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						tfTitle,
																						javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jScrollPane1,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						445,
																						Short.MAX_VALUE)))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addContainerGap()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jScrollPane2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						209,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						lNumberOfItems,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						197,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(bSave)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).
																addComponent(lFind)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(tfFind)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(lDate)
																.addGap(67, 67, 67)
																.addComponent(lTime)
																.addGap(35, 35, 35)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.CENTER)
												.addComponent(lNumberOfItems).addComponent(bSave).addComponent(lFind)
												.addComponent(lTime).addComponent(lDate)
												.addComponent(tfFind, 30, 30, 30))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		tfTitle,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		45,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		307, Short.MAX_VALUE))
												.addComponent(jScrollPane2)).addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bSaveActionPerformed
		writeLog();
	}// GEN-LAST:event_bSaveActionPerformed

	private void bNewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bNewActionPerformed
		insertEntry.setVisible(true);
	}// GEN-LAST:event_bNewActionPerformed

	private void listEntriesMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_listEntriesMouseClicked
		int chosen = listEntries.getSelectedIndex();
		if (chosen != -1) {
			Entry value = (Entry) (Object)listEntries.getSelectedValue();
			chosen = entries.indexOf(value);
			tfTitle.setText(entries.get(chosen).title());
			taContent.setText(entries.get(chosen).content());
			
			searchHighLight.removeAllHighlights();
			String finding = tfFind.getText();
			if (finding.length() != 0) {
				int start = 0;
				int index = 99999;
				while (true) {
					index = taContent.getText().indexOf(finding, start);
					if (index == -1) {
						break;
					} else {
						start = index + finding.length();
						try {
							searchHighLight.addHighlight(index, start, highlightPainter);
						} catch (BadLocationException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			if (preview) {
				preview = false;
				tfTitle.setEditable(true);
				taContent.setEditable(true);
			}
		}
	}// GEN-LAST:event_listEntriesMouseClicked

	private void listEntriesKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_listEntriesKeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
			int chosen = listEntries.getSelectedIndex();
			if (chosen != -1) {
				entries.remove(chosen);
				listModel.remove(chosen);
				updateNumberOfItems();
				clearText();
			}
		}
	}// GEN-LAST:event_listEntriesKeyPressed

	private void miPreviewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miPreviewActionPerformed
		if (!preview) {
			updateCurrentEntry();
		}
		preview = true;
		writeLog();
		tfTitle.setText("Preview Log...");
		taContent.setText(new String(logContent));
		tfTitle.setEditable(false);
		taContent.setEditable(false);
	}// GEN-LAST:event_miPreviewActionPerformed

	private void miFindActionPerformed(java.awt.event.ActionEvent evt) {
		tfFind.setText("");
		tfFind.requestFocus();
	}
	
	private void miSaveToFileActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miSaveToFileActionPerformed
		saveLog(chooseFile("Save Log"));
	}// GEN-LAST:event_miSaveToFileActionPerformed

	private void miExitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miExitActionPerformed
		exit();
	}// GEN-LAST:event_miExitActionPerformed

	private void tfTitleKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_tfTitleKeyReleased
		if (!preview) {
			updateCurrentEntry();
		}
	}// GEN-LAST:event_tfTitleKeyReleased

	private void taContentKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_taContentKeyReleased
		if (!preview) {
			updateCurrentEntry();
		}
	}// GEN-LAST:event_taContentKeyReleased

	private void miLoadActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miLoadActionPerformed
		loadPreviousLog();
	}// GEN-LAST:event_miLoadActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainScreen().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton bNew;
	private JButton bSave;
	private JMenu mFile;
	private JMenu mEdit;
	private JMenu mOption;
	private JMenuBar mbMain;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JPopupMenu.Separator jSeparator1;
	private JLabel lDate;
	private JLabel lNumberOfItems;
	private JLabel lTime;
	private JList<String> listEntries;
	private JMenuItem miNew, miFind;
	private JMenuItem miExit;
	private JMenuItem miLoad;
	private JMenuItem miPreview;
	private JMenuItem miSaveToFile;
	private JCheckBoxMenuItem cbmiIncrementalSearch;
	private JTextArea taContent;
	private JTextField tfTitle;
	private JLabel lFind;
	private JTextField tfFind;
	
	private Highlighter searchHighLight;
	private HighlightPainter highlightPainter;
	
	// End of variables declaration//GEN-END:variables
	private final StringBuilder logContent;
	private final ScheduledThreadPoolExecutor timer;
	private final ArrayList<Entry> entries;
	private final DefaultListModel listModel;
	private final InsertEntry insertEntry;
	private boolean preview;
	private static final String FILE_SAVE_NAME = "Current.log";
	private static final SimpleDateFormat DEFAULT_TIME = new SimpleDateFormat("HH : mm : ss");
	protected static final SimpleDateFormat DEFAULT_DATE = new SimpleDateFormat("dd - MMMM - yyyy",
			Locale.ENGLISH);
	protected static final SimpleDateFormat DEFAULT_DISPLAY_DATE = new SimpleDateFormat("dd/MM/yyyy",
			Locale.ENGLISH);

	protected void addEntry(Entry entry) {
		preview = true;
		entries.add(entry);
		Entry.sort(entries);
		listModel.clear();
		synchronized (entries) {
			for (Entry current : entries) {
				listModel.addElement(current);
			}
		}
		updateNumberOfItems();
	}

	private void updateNumberOfItems() {
		lNumberOfItems.setText(listEntries.getModel().getSize() + " item(s)");
	}

	private void updateCurrentEntry() {
		if (!preview) {
			int chosen = listEntries.getSelectedIndex();
			if (chosen != -1) {
				Entry entry = (Entry) (Object) listEntries.getSelectedValue();
				chosen = entries.indexOf(entry);
				entries.get(chosen).updateTitle(tfTitle.getText());
				entries.get(chosen).update(taContent.getText());
			}
		}
	}

	private void loadPreviousLog() {
		File load = chooseFile("Load Log");
		loadList(load);
	}

	private boolean loadList(File file) {// Return if success
		FileReader fr = null;
		try {
			// Only use at the very beginning to load data
			if (file == null) {
				return true;
			}
			Calendar currentEntryTime;
			String currentTitle;
			StringBuilder currentContent = new StringBuilder();
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			do {
				do {
					line = br.readLine();
					if (line == null) {
						preview = true;
						updateNumberOfItems();
						br.close();
						return true;
					}
				} while (!line.equals(Entry.START_LOG));

				line = br.readLine();
				line = line.substring(Entry.DATE.length());
				currentEntryTime = Calendar.getInstance();
				currentEntryTime.setTime(DEFAULT_DATE.parse(line));

				currentTitle = br.readLine().substring(Entry.TITLE.length());
				br.readLine();

				line = br.readLine();
				if (!line.equals(Entry.CONTENT)) {
					resetEverything();
					br.close();
					return false; // Invalid save file
				}
				currentContent.delete(0, currentContent.length());
				do {
					line = br.readLine();
					if (line.equals(Entry.END_LOG)) {
						break;
					}
					if (line == null) {
						resetEverything();
						br.close();
						return false; // Invalid save file
					}
					currentContent.append(line).append("\n");
				} while (true);

				line = currentContent.toString();
				line = line.trim();

				br.readLine();
				br.readLine();
				br.readLine();
				br.readLine();

				Entry toBeAdd = new Entry(currentEntryTime, currentTitle, line);
				entries.add(toBeAdd);
				listModel.addElement(toBeAdd);
			} while (true);
		} catch (ParseException ex) {
			Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
			resetEverything();
			return false; // Invalid save file
		} catch (IOException ex) {
			Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
			resetEverything();
			return false; // Error reading save file
		} finally {
			try {
				if (fr != null) {
					fr.close();
				} else {
					return true;
				}
				return true;
			} catch (IOException ex) {
				Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
				resetEverything();
				return false; // Error reading save file
			}
		}
	}

	private void resetEverything() {
		entries.clear();
		listModel.clear();
	}

	private void clearText() {
		tfTitle.setText("");
		taContent.setText("");
	}

	private void writeLog() {
		logContent.delete(0, logContent.length());
		for (int i = 0; i < entries.size(); i++) {
			entries.get(i).write(logContent);
		}
	}

	private void saveLog(File file) {
		synchronized (logContent) {
			if (logContent.length() == 0) {
				return;
			}
			FileWriter fr = null;
			try {
				if (file == null) {
					file = new File(FILE_SAVE_NAME + System.currentTimeMillis());
					file.createNewFile();
				}
				file.setWritable(true);
				fr = new FileWriter(file);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(new String(logContent));
				br.flush();
			} catch (IOException ex) {
				Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				try {
					fr.close();
				} catch (IOException ex) {
					Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
				}
			}

		}
	}

	private void exit() {
		int result = JOptionPane.showConfirmDialog(null, "Save Work?", "Save", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			saveLog(chooseFile("Save Log"));
		} else if (result == JOptionPane.NO_OPTION) {
			System.exit(0);
		}
	}

	private class AutoSave implements Runnable {

		@Override
		public void run() {
			writeLog();
			saveLog(new File(DEFAULT_DATE.format(new Date())));
		}
	}

	private class UpdateTime implements Runnable {

		@Override
		public void run() {
			Date now = new Date();
			lTime.setText(DEFAULT_TIME.format(now));
			lDate.setText(DEFAULT_DATE.format(now));
		}
	}

	private File chooseFile(String job) {
		JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));
		chooser.setApproveButtonText(job);
		chooser.setSelectedFile(new File(DEFAULT_DATE.format(new Date())));
		int chosen = chooser.showOpenDialog(this);
		if (chosen == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		} else {
			return null;
		}
	}
}
