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
    id: number
    version: number
    titre: string
    duree: number
    piste: Array<number>
    artiste: any
    auditeurs: Array<any>
    listePlaylistAssociees: Array<any>
  
    constructor(id?: number,
      version?: number,
      titre?: string,
      duree?: number,
      piste?: Array<number>,
      artiste?: any,
      auditeurs?: Array<any>,
      listePlaylistAssociees?: Array<any>)
       {
        this.id = id
        this.version = version
        this.titre = titre
        this.duree = duree
        this.piste = piste ? piste : [];
        this.artiste = artiste
        this.auditeurs = auditeurs
        this.listePlaylistAssociees = listePlaylistAssociees
      }
  }

    export class Musique extends Contenu {

        genre:string;
        auteur: Compte;

        constructor(id?: number,
            version?: number,
            titre?: string,
            duree?: number,
            piste?: Array<number>,
            artiste?: any,
            auditeurs?: Array<any>,
            listePlaylistAssociees?: Array<any>, genre?:string, auteur?:Compte){
            super(id, version,titre,duree, piste, artiste, auditeurs, listePlaylistAssociees);
           this.genre=genre;
           this.auteur=auteur;
        }
    }

