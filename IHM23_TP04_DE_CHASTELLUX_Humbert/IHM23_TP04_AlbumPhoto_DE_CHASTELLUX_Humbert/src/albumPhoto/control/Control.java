package albumPhoto.control;

import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class Control {
	private ControlNavigationButtons controlButtons;
	private ControlCentralImage controlCentralImage;
	private ControlPhotoName controlPhotoName;
	private ControlList controlList;
	private ControlMenuNew controlMenuNew;
	private ControlMenuQuit controlMenuQuit;
	private ControlZoom controlZoom;
	private ControlThumbnails controlThumbnails;

	public Control(Album model) {
		this.controlButtons = new ControlNavigationButtons(model);
		this.controlCentralImage = new ControlCentralImage(model);
		this.controlPhotoName = new ControlPhotoName(model);
		this.controlList = new ControlList(model);
		this.controlMenuNew = new ControlMenuNew(model);
		this.controlMenuQuit = new ControlMenuQuit();
		this.controlZoom = new ControlZoom(model);
		this.controlThumbnails = new ControlThumbnails(model);
	}
	public ControlCentralImage getControlCentralImage() {
		return this.controlCentralImage;
	}
	public ControlNavigationButtons getControlButtons() {
		return this.controlButtons;
	}
	public ControlList getControlList() {
		return this.controlList;
	}
	public ControlMenuNew getControlMenuNew() {
		return this.controlMenuNew;
	}
	public ControlMenuQuit getControlMenuQuit() {
		return this.controlMenuQuit;
	}
	public ControlZoom getControlZoom() {
		return this.controlZoom;
	}
	public ControlThumbnails getControlThumbnails() {
		return this.controlThumbnails;
	}
	public ControlPhotoName getControlPhotoName() {
		return this.controlPhotoName;
	}
	public void connectPresentation(FrameAlbumPhoto presentation) {
		this.controlButtons.connectPresentation(presentation);
		this.controlCentralImage.connectPresentation(presentation);
		this.controlPhotoName.connectPresentation(presentation);
		this.controlList.connectPresentation(presentation);
		this.controlZoom.connectPresentation(presentation);
		this.controlThumbnails.connectPresentation(presentation);
	}
}
