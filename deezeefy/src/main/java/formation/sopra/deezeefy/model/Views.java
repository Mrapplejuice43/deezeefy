package formation.sopra.deezeefy.model;

public class Views {

	public static class ViewBase {}


	// ============= Contenu ===================
	public static class ViewContenu extends ViewBase {}

	public static class ViewMusique extends ViewContenu {}

	public static class ViewPodcast extends ViewContenu {}

	public static class ViewContenuDetailed extends ViewBase {}

	public static class ViewContenuWithAuditeurs extends ViewContenuDetailed {}

	public static class ViewContenuWithPlaylistAssociees extends ViewContenuDetailed {}
	// =========================================


	// ============= Compte History ===================
	public static class ViewCompteHistory extends ViewBase {}
	// =========================================


	// ============= Compte ===================
	public static class ViewCompte extends ViewBase {}

	public static class ViewCompteDetailed extends ViewBase {}

	public static class ViewCompteWithCompteHistory extends ViewCompteDetailed {}

	public static class ViewCompteWithPlaylistCrees extends ViewCompteDetailed {}

	public static class ViewCompteWithListPlaylistSuivies extends  ViewCompteDetailed {}

	public static class ViewCompteWithListeComptesSuivis extends ViewCompteDetailed {}

	public static class ViewCompteWithListeFollowers extends ViewCompteDetailed {}

	// === Artiste
	public static class ViewArtiste extends ViewCompte {}

	private static class ViewArtisteDetailed extends ViewArtiste {}

	public static class ViewArtisteWithListeContenu extends ViewArtisteDetailed {}
	// ===========

	// === Utilisateur
	public static class ViewUtilistateur extends ViewCompte {}
	// ===========

	// === Admin
	public static class ViewAdmin extends ViewCompte {}
	// ===========
	// =========================================


	// ============= Compte Follower ===================
	public static class ViewCompteFollower extends ViewBase {}
	// =========================================


	// ============= Playlist Follower ===================
	public static class ViewPlaylistFollower extends ViewBase {}
	// =========================================


	// ============= Contenu Playlist ===================
	public static class ViewContenuPlaylist extends ViewBase {}
	// =========================================


	// ============= Playlist ===================
	public static class ViewPlaylist extends ViewBase {}

	private static class ViewPlaylistDetailed extends ViewBase {}

	public static class ViewPlaylistWithListeFollowers extends ViewPlaylistDetailed{}

	public static class ViewPlaylistWithListeContenuAssocie extends ViewPlaylistDetailed {}
	// =========================================

}
