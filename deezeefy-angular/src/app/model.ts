export const COMPTE_ADMIN = "admin"
export const COMPTE_UTILISATEUR = "user"
export const COMPTE_ARTISTE = "artiste"

export abstract class Compte {

    id: number;
    version: number;
    type:string;
    email:string;
    login:string;
    password:string;
    nom:string;
    prenom:string;
    pseudo:string;

    constructor(id?:number, version?: number , type?: string, nom?: string, prenom?: string, email? :string,login?:string,password?:string,pseudo?:string ) {
        this.id = id;
        this.version = version;
        this.login = login;
        this.password = password;
        this.email=email;
    }
}

export class Admin extends Compte {

    constructor(id?:number, version?: number, type?: string, nom?: string, prenom?: string, email? :string,login?:string,password?:string,pseudo?:string) {
        super(id, version, type, nom, prenom, email,login,password,pseudo);

    }
}

export class Utilisateur extends Compte {

    abonnement:string;
    tempsEcoute : number;

    constructor(id?:number, version?: number, type?: string, nom?: string, prenom?: string, email? :string,login?:string,password?:string,pseudo?:string, abonnement?:string,tempsEcoute?:number) {
        super(id, version, type, nom, prenom, email,login,password,pseudo);
        this.abonnement=abonnement;
        this.tempsEcoute=tempsEcoute;
    }
}

export class Artiste extends Compte {
    biographie: string;
    nbAuditeur : number;

    constructor(id?:number, version?: number, type?: string, nom?: string, prenom?: string, email? :string,login?:string,password?:string,pseudo?:string, biographie?:string, nbAuditeur?:number) {
    super(id, version, type, nom, prenom, email,login,password,pseudo);
    this.biographie=biographie;
    this.nbAuditeur=nbAuditeur;
    }
}
export class AuthDTO {
    login: string;
    password: string;

    constructor(login?: string, password?: string) {
      this.login = login;
      this.password = password;
    }

    isValide():boolean{
        return(Boolean(this.login) && Boolean(this.password));
    }
  }

export class CompteHistory {
  id: number
  version: number
  dateDerniereEcoute: string
  nombreEcoutes: number
  compte: Compte
  contenu: Contenu

  constructor(
    id?: number,
    version?: number,
    dateDerniereEcoute?: string,
    nombreEcoutes?: number,
    compte?: Compte,
    contenu?: Contenu) {
      this.id = id
      this.version = version
      this.dateDerniereEcoute = dateDerniereEcoute
      this.nombreEcoutes = nombreEcoutes
      this.compte = compte
      this.contenu = contenu
    }
}

export abstract class Contenu {
    id: number
    version: number
    titre: string
    duree: number
    piste: Array<number>
    auteur: any
    auditeurs: Array<any>
    listePlaylistAssociees: Array<any>

    constructor(id?: number,
      version?: number,
      titre?: string,
      duree?: number,
      piste?: Array<number>,
      auteur?: any,
      auditeurs?: Array<any>,
      listePlaylistAssociees?: Array<any>)
       {
        this.id = id
        this.version = version
        this.titre = titre
        this.duree = duree
        this.piste = piste ? piste : [];
        this.auteur = auteur
        this.auditeurs = auditeurs
        this.listePlaylistAssociees = listePlaylistAssociees
      }
  }

    export class Musique extends Contenu {

        genre:string;

        constructor(id?: number,
            version?: number,
            titre?: string,
            duree?: number,
            piste?: Array<number>,
            auteur?: Compte,
            auditeurs?: Array<any>,
            listePlaylistAssociees?: Array<any>, genre?:string){
            super(id, version,titre,duree, piste, auteur, auditeurs, listePlaylistAssociees);
           this.genre=genre;
           this.auteur=auteur;
        }
    }



export class Playlist {
    id: number;
    version: number;
    titre: string;
    duree: number;
    dateCreation: string;
    nbContenu: number;
    typePlaylist: string;
    createur: Compte;

    constructor(id?:number, version?:number, titre?: string, duree?: number, dateCreation?: string, nbContenu?: number, typePlaylist?: string, createur?: Compte){
        this.id=id;
        this.version=version;
        this.titre=titre;
        this.duree=duree;
        this.dateCreation=dateCreation;
        this.typePlaylist=typePlaylist;
        this.createur=createur;
    }

}

export class ContenuPlaylist{

    id: number;
    version: number;
    dateAjout: string;
    contenuAssocie: number;
    playlistAssociee: number;

    constructor(id?:number, version?:number, dateAjout?: string, contenuAssocie?: number, playlistAssociee?: number){
        this.id=id;
        this.version=version;
        this.dateAjout=dateAjout;
        this.contenuAssocie=contenuAssocie;
        this.playlistAssociee=playlistAssociee;
    }

    

}
