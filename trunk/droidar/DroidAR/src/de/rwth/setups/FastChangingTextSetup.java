package de.rwth.setups;

import java.util.HashMap;

import commands.Command;

import android.app.Activity;

import gl.GLFactory;
import gl.GLRenderer;
import gl.GLText;
import gl.scenegraph.MeshComponent;
import gui.GuiSetup;
import system.DefaultARSetup;
import worldData.Obj;
import worldData.World;

public class FastChangingTextSetup extends DefaultARSetup {

	HashMap<String, MeshComponent> textMap = new HashMap<String, MeshComponent>();
	private GLText text;

	@Override
	public void addObjectsTo(GLRenderer renderer, World world,
			GLFactory objectFactory) {

		text = new GLText("11223344swrvgweln@@@@", myTargetActivity, textMap,
				getCamera());

		Obj o = new Obj();
		o.setComp(text);
		world.add(o);
	}

	@Override
	public void _e2_addElementsToGuiSetup(GuiSetup guiSetup, Activity activity) {
		guiSetup.addSearchbarToView(guiSetup.getBottomView(), new Command() {

			@Override
			public boolean execute() {
				return false;
			}

			@Override
			public boolean execute(Object transfairObject) {
				if (transfairObject instanceof String) {
					String s = (String) transfairObject;
					text.changeTextTo(s);
				}
				return true;
			}
		}, "Enter text");
	}

}
