package com.laquysoft.uriexplained;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;


import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.net.URI;

public class UriComponentsVisualizer extends JFrame {

	private static final long serialVersionUID = 1L;


	protected JLabel uriLabel;
	protected JLabel schemeLabel;
	protected JLabel authorityLabel;
	protected JLabel pathLabel;
	protected JLabel queryLabel;
	protected JLabel fragmentLabel;

	protected JTextField uriTf;
	protected JTextField schemeTf;
	protected JTextField authorityTf;
	protected JTextField pathTf;
	protected JTextField queryTf;
	protected JTextField fragmentTf;


	public UriComponentsVisualizer() {
		initComponents();

	}

	private void initComponents() {
		setTitle("Uri Components Visualizer");
		setSize(300, 200);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JPanel panel = new JPanel();
		panel.setSize(300, 200);

		uriLabel = new JLabel("URI");
		schemeLabel = new JLabel("Scheme");
		authorityLabel = new JLabel("Authority");
		pathLabel = new JLabel("Path");
		queryLabel = new JLabel("Query");
		fragmentLabel = new JLabel("Fragment");

		uriTf = new JTextField(20);
		schemeTf = new JTextField(30);
		authorityTf = new JTextField(30);
		pathTf = new JTextField(30);
		queryTf = new JTextField(30);
		fragmentTf = new JTextField(30);

		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup().
				addComponent(uriLabel).
				addComponent(schemeLabel).addComponent(authorityLabel).
				addComponent(pathLabel).addComponent(queryLabel).addComponent(fragmentLabel));

		hGroup.addGroup(layout.createParallelGroup().
				addComponent(uriTf).addComponent(schemeTf).addComponent(authorityTf)
				.addComponent(pathTf).addComponent(queryTf).addComponent(fragmentTf));
		layout.setHorizontalGroup(hGroup);

		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(uriLabel).addComponent(uriTf));


		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(schemeLabel).addComponent(schemeTf));

		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(authorityLabel).addComponent(authorityTf));

		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(pathLabel).addComponent(pathTf));

		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(queryLabel).addComponent(queryTf));

		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(fragmentLabel).addComponent(fragmentTf));

		layout.setVerticalGroup(vGroup);



		uriTf.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String uriText = uriTf.getText();
				schemeTf.setText("");
				authorityTf.setText("");
				pathTf.setText("");
				fragmentTf.setText("");
				queryTf.setText("");
				if ( uriText != null )
				{
					try {


						URI uri = new URI(uriText);
						schemeTf.setText(uri.getScheme());
						authorityTf.setText(uri.getAuthority());
						pathTf.setText(uri.getPath());
						fragmentTf.setText(uri.getFragment());
						queryTf.setText(uri.getQuery());

					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					} 
				}

			}
		});

		getContentPane().add(panel);
		setVisible(true);
		pack();
	}



	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new UriComponentsVisualizer();
			}
		});
	}
}
