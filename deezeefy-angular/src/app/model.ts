
export abstract class Contenu {
    id:number;
    version:number;
    titre:string;
    duree:number;

    constructor(id?:number, version?:number, titre?:string, duree?:number ){
        this.id=id;
        this.version=version;
        this.titre=titre;
        this.duree=duree;
    }
}
    export class Musique extends Contenu {
       
        genre:string;
    
        constructor(id?:number, version?:number, titre?:string, duree?:number, genre?:string ){
            super(id, version,titre,duree);
           this.genre=genre;
        }
    }
