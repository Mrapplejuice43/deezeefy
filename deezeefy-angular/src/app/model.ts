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

    constructor(id?:number, version?: number , type?: string, nom?: string, prenom?: string, email? :string,login?:string,password?:string,pseudo?:string) {
        this.id = id;
        this.version = version;
        this.login = login;
        this.password = password;
    }
}

export class Admin extends Compte {

    constructor(id?:number, version?: number, type?: string, nom?: string, prenom?: string, email? :string,login?:string,password?:string,pseudo?:string) {
        super(id, version, type, nom, prenom, email,login,password,pseudo);

    }
}

export class Artiste extends Compte {     
    biographie: string;    
    nbAuditeur : number;    
    
    constructor(id?:number, version?: number, type?: string, nom?: string, prenom?: string, email? :string,login?:string,password?:string,pseudo?:string, biographie?:string, nbAuditeur?:number) {        
    super(id, version, type, nom, prenom, email,login,password,pseudo);        
    this.biographie=biographie;        
    this.nbAuditeur=nbAuditeur;    
    }}
    

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
