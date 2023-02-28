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
    

export abstract class Contenu {
    id:number;
    version:number;
    titre:string;
    duree:number;
    auteur: Artiste;

    constructor(id?:number, version?:number, titre?:string, duree?:number, auteur?: Artiste ){
        this.id=id;
        this.version=version;
        this.titre=titre;
        this.duree=duree;
        this.auteur=auteur;
    }
}
    export class Musique extends Contenu {

        genre:string;

        constructor(id?:number, version?:number, titre?:string, duree?:number, genre?:string ){
            super(id, version,titre,duree);
           this.genre=genre;
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
    contenuAssocie: Musique;
    playlistAssociee: Playlist;

    constructor(id?:number, version?:number, dateAjout?: string, contenuAssocie?: Musique, playlistAssociee?: Playlist){
        this.id=id;
        this.version=version;
        this.dateAjout=dateAjout;
        this.contenuAssocie=contenuAssocie;
        this.playlistAssociee=playlistAssociee;
    }

    

}
