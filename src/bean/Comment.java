package bean;

import java.util.List;
/**
 * Created by MiChong on 2017/11/22 0022.
 */
public class Comment {


    /**
     * result : {"songs":[{"duration":135079,"rtype":0,"ftype":0,"artists":[{"img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"name":"梅林茂","alias":[],"id":160517,"albumSize":0,"picId":0}],"copyrightId":0,"album":{"publishTime":1001433600007,"size":29,"artist":{"img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"name":"","alias":[],"id":0,"albumSize":0,"picId":0},"copyrightId":0,"name":"阴阳师 \u2015オリジナル・サウンドトラック","id":195808,"picId":1655864511431151,"status":1},"fee":0,"mvid":0,"name":"蜜虫","alias":[],"id":1944624,"status":0}],"order":["songs"]}
     * code : 200
     */
    private ResultEntity result;
    private int code;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResultEntity getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public class ResultEntity {
        /**
         * songs : [{"duration":135079,"rtype":0,"ftype":0,"artists":[{"img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"name":"梅林茂","alias":[],"id":160517,"albumSize":0,"picId":0}],"copyrightId":0,"album":{"publishTime":1001433600007,"size":29,"artist":{"img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"name":"","alias":[],"id":0,"albumSize":0,"picId":0},"copyrightId":0,"name":"阴阳师 \u2015オリジナル・サウンドトラック","id":195808,"picId":1655864511431151,"status":1},"fee":0,"mvid":0,"name":"蜜虫","alias":[],"id":1944624,"status":0}]
         * order : ["songs"]
         */
        private List<SongsEntity> songs;
        private List<String> order;

        public void setSongs(List<SongsEntity> songs) {
            this.songs = songs;
        }

        public void setOrder(List<String> order) {
            this.order = order;
        }

        public List<SongsEntity> getSongs() {
            return songs;
        }

        public List<String> getOrder() {
            return order;
        }

        public class SongsEntity {
            /**
             * duration : 135079
             * rtype : 0
             * ftype : 0
             * artists : [{"img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"name":"梅林茂","alias":[],"id":160517,"albumSize":0,"picId":0}]
             * copyrightId : 0
             * album : {"publishTime":1001433600007,"size":29,"artist":{"img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"name":"","alias":[],"id":0,"albumSize":0,"picId":0},"copyrightId":0,"name":"阴阳师 \u2015オリジナル・サウンドトラック","id":195808,"picId":1655864511431151,"status":1}
             * fee : 0
             * mvid : 0
             * name : 蜜虫
             * alias : []
             * id : 1944624
             * status : 0
             */
            private int duration;
            private int rtype;
            private int ftype;
            private List<ArtistsEntity> artists;
            private int copyrightId;
            private AlbumEntity album;
            private int fee;
            private int mvid;
            private String name;
            private List<?> alias;
            private int id;
            private int status;

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public void setRtype(int rtype) {
                this.rtype = rtype;
            }

            public void setFtype(int ftype) {
                this.ftype = ftype;
            }

            public void setArtists(List<ArtistsEntity> artists) {
                this.artists = artists;
            }

            public void setCopyrightId(int copyrightId) {
                this.copyrightId = copyrightId;
            }

            public void setAlbum(AlbumEntity album) {
                this.album = album;
            }

            public void setFee(int fee) {
                this.fee = fee;
            }

            public void setMvid(int mvid) {
                this.mvid = mvid;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getDuration() {
                return duration;
            }

            public int getRtype() {
                return rtype;
            }

            public int getFtype() {
                return ftype;
            }

            public List<ArtistsEntity> getArtists() {
                return artists;
            }

            public int getCopyrightId() {
                return copyrightId;
            }

            public AlbumEntity getAlbum() {
                return album;
            }

            public int getFee() {
                return fee;
            }

            public int getMvid() {
                return mvid;
            }

            public String getName() {
                return name;
            }

            public List<?> getAlias() {
                return alias;
            }

            public int getId() {
                return id;
            }

            public int getStatus() {
                return status;
            }

            public class ArtistsEntity {
                /**
                 * img1v1Url : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * img1v1 : 0
                 * name : 梅林茂
                 * alias : []
                 * id : 160517
                 * albumSize : 0
                 * picId : 0
                 */
                private String img1v1Url;
                private int img1v1;
                private String name;
                private List<?> alias;
                private int id;
                private int albumSize;
                private int picId;

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public void setImg1v1(int img1v1) {
                    this.img1v1 = img1v1;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public int getImg1v1() {
                    return img1v1;
                }

                public String getName() {
                    return name;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public int getId() {
                    return id;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public int getPicId() {
                    return picId;
                }
            }

            public class AlbumEntity {
                /**
                 * publishTime : 1001433600007
                 * size : 29
                 * artist : {"img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"name":"","alias":[],"id":0,"albumSize":0,"picId":0}
                 * copyrightId : 0
                 * name : 阴阳师 ―オリジナル・サウンドトラック
                 * id : 195808
                 * picId : 1655864511431151
                 * status : 1
                 */
                private long publishTime;
                private int size;
                private ArtistEntity artist;
                private int copyrightId;
                private String name;
                private int id;
                private long picId;
                private int status;

                public void setPublishTime(long publishTime) {
                    this.publishTime = publishTime;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public void setArtist(ArtistEntity artist) {
                    this.artist = artist;
                }

                public void setCopyrightId(int copyrightId) {
                    this.copyrightId = copyrightId;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setPicId(long picId) {
                    this.picId = picId;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public long getPublishTime() {
                    return publishTime;
                }

                public int getSize() {
                    return size;
                }

                public ArtistEntity getArtist() {
                    return artist;
                }

                public int getCopyrightId() {
                    return copyrightId;
                }

                public String getName() {
                    return name;
                }

                public int getId() {
                    return id;
                }

                public long getPicId() {
                    return picId;
                }

                public int getStatus() {
                    return status;
                }

                public class ArtistEntity {
                    /**
                     * img1v1Url : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * img1v1 : 0
                     * name :
                     * alias : []
                     * id : 0
                     * albumSize : 0
                     * picId : 0
                     */
                    private String img1v1Url;
                    private int img1v1;
                    private String name;
                    private List<?> alias;
                    private int id;
                    private int albumSize;
                    private int picId;

                    public void setImg1v1Url(String img1v1Url) {
                        this.img1v1Url = img1v1Url;
                    }

                    public void setImg1v1(int img1v1) {
                        this.img1v1 = img1v1;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public void setAlias(List<?> alias) {
                        this.alias = alias;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public void setAlbumSize(int albumSize) {
                        this.albumSize = albumSize;
                    }

                    public void setPicId(int picId) {
                        this.picId = picId;
                    }

                    public String getImg1v1Url() {
                        return img1v1Url;
                    }

                    public int getImg1v1() {
                        return img1v1;
                    }

                    public String getName() {
                        return name;
                    }

                    public List<?> getAlias() {
                        return alias;
                    }

                    public int getId() {
                        return id;
                    }

                    public int getAlbumSize() {
                        return albumSize;
                    }

                    public int getPicId() {
                        return picId;
                    }
                }
            }
        }
    }
}
